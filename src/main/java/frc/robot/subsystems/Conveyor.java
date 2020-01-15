package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.EncoderConstants;
import frc.robot.Constants.TalonConstants;
import frc.robot.EncoderUtils;
import frc.robot.SubsystemDevices;
import frc.robot.brains.ConveyorBrain;
import frc.robot.consoles.Logger;

// Conveyor subsystem, for grabbing and releasing hatches
public class Conveyor extends SubsystemBase {

    // The public property to determine the Conveyor's claw state
    public boolean clawIsClosed = false;

    // Position constants
    private final double GEAR_RATIO = 16;

    // Encoder constants
    private final boolean SENSOR_PHASE = true; // So that Talon does not report sensor out of phase
    private final boolean MOTOR_INVERT = false; // Which direction you want to be positive; this does not affect motor invert

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Conveyor...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.talonSrxConveyor == null);
        if (m_disabled) {
            Logger.error("Conveyor devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        SubsystemDevices.talonSrxConveyor.configFactoryDefault();

        SubsystemDevices.talonSrxConveyor.configPeakCurrentDuration(TalonConstants.PEAK_AMPERAGE_DURATION,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configPeakCurrentLimit(TalonConstants.PEAK_AMPERAGE,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configContinuousCurrentLimit(TalonConstants.CONTINUOUS_AMPERAGE_LIMIT,
                TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSrxConveyor.configNominalOutputForward(0);
        SubsystemDevices.talonSrxConveyor.configNominalOutputReverse(0);
        SubsystemDevices.talonSrxConveyor.configPeakOutputForward(0.5);
        SubsystemDevices.talonSrxConveyor.configPeakOutputReverse(-0.5);

        SubsystemDevices.talonSrxConveyor.configMotionAcceleration(3000, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configMotionCruiseVelocity(8000, TalonConstants.TIMEOUT_MS);

        // Config TalonSRX Redline encoder
        SubsystemDevices.talonSrxConveyor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,
                EncoderConstants.PID_LOOP_PRIMARY, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.setSensorPhase(SENSOR_PHASE);
        SubsystemDevices.talonSrxConveyor.setInverted(MOTOR_INVERT);
        SubsystemDevices.talonSrxConveyor.configAllowableClosedloopError(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSrxConveyor.config_kF(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.config_kP(EncoderConstants.PID_LOOP_PRIMARY, 0.32, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.config_kI(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.config_kD(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);

        // Initialize current encoder position as zero
        SubsystemDevices.talonSrxConveyor.setSelectedSensorPosition(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);
        SensorCollection sensorCol = SubsystemDevices.talonSrxConveyor.getSensorCollection();
        int absolutePosition = sensorCol.getPulseWidthPosition();
        absolutePosition &= 0xFFF;
        if (SENSOR_PHASE)
            absolutePosition *= -1;
        if (MOTOR_INVERT)
            absolutePosition *= -1;
        // Set the quadrature (relative) sensor to match absolute
        SubsystemDevices.talonSrxConveyor.setSelectedSensorPosition(absolutePosition, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Toggle the clawIsClosed state
    public void toggleClawPosition() {
        clawIsClosed = !clawIsClosed;
    }

    // Stop the Conveyor claw motor
    public void stop() {
        if (m_disabled)
            return;
        SubsystemDevices.talonSrxConveyor.stopMotor();
    }

    // Open the Conveyor claw
    public void openClaw() {
        double angle = ConveyorBrain.getHatchOpenAngle();
        double ticks = EncoderUtils.translateAngleToTicks(angle, GEAR_RATIO);
        Logger.info("Conveyor -> Motion Magic to OPEN: " + angle + " angle, " + ticks + " ticks");

        if (m_disabled)
            return;
        SubsystemDevices.talonSrxConveyor.set(ControlMode.MotionMagic, ticks);
    }

    // Close the Conveyor claw
    public void closeClaw() {
        double angle = ConveyorBrain.getHatchCloseAngle();
        double ticks = EncoderUtils.translateAngleToTicks(angle, GEAR_RATIO);
        Logger.info("Conveyor -> Motion Magic to CLOSE: " + angle + " angle, " + ticks + " ticks");

        if (m_disabled)
            return;
        SubsystemDevices.talonSrxConveyor.set(ControlMode.MotionMagic, ticks);
    }

    // Get the current Conveyor claw motor velocity
    public int getVelocity() {
        if (m_disabled)
            return 0;
        return SubsystemDevices.talonSrxConveyor.getSelectedSensorVelocity();
    }

    // Get the current Conveyor claw motor position
    public int getPosition() {
        if (m_disabled)
            return 0;
        return SubsystemDevices.talonSrxConveyor.getSelectedSensorPosition();
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        if (m_disabled)
            return;
        SubsystemDevices.talonSrxConveyor.set(0.2);
    }

}
