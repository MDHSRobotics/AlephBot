
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.talonSrxColorWheel;
import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.constants.TalonConstants.*;
import frc.robot.subsystems.utils.EncoderUtils;

// Conveyor subsystem, for moving a ball up to the shooter
public class ColorWheel extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    // Position constants
    private final double GEAR_RATIO = 16;

    // Encoder constants
    private final boolean SENSOR_PHASE = true; // So that Talon does not report sensor out of phase
    private final boolean MOTOR_INVERT = false; // Which direction you want to be positive; this does not affect motor invert

    public ColorWheel() {
        Logger.setup("Constructing Subsystem: Color Wheel...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxColorWheel == null);
        if (m_disabled) {
            Logger.error("Color Wheel devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        talonSrxColorWheel.configFactoryDefault();

        talonSrxColorWheel.configPeakCurrentDuration(PEAK_AMPERAGE_DURATION, TIMEOUT_MS);
        talonSrxColorWheel.configPeakCurrentLimit(PEAK_AMPERAGE, TIMEOUT_MS);
        talonSrxColorWheel.configContinuousCurrentLimit(CONTINUOUS_AMPERAGE_LIMIT, TIMEOUT_MS);

        talonSrxColorWheel.configNominalOutputForward(0);
        talonSrxColorWheel.configNominalOutputReverse(0);
        talonSrxColorWheel.configPeakOutputForward(0.5);
        talonSrxColorWheel.configPeakOutputReverse(-0.5);

        talonSrxColorWheel.configMotionAcceleration(3000, TIMEOUT_MS);
        talonSrxColorWheel.configMotionCruiseVelocity(8000, TIMEOUT_MS);

        // Config TalonSRX Redline encoder
        talonSrxColorWheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, PID_LOOP_PRIMARY, TIMEOUT_MS);
        talonSrxColorWheel.setSensorPhase(SENSOR_PHASE);
        talonSrxColorWheel.setInverted(MOTOR_INVERT);
        talonSrxColorWheel.configAllowableClosedloopError(0, PID_LOOP_PRIMARY, TIMEOUT_MS);

        talonSrxColorWheel.config_kF(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);
        talonSrxColorWheel.config_kP(PID_LOOP_PRIMARY, 0.32, TIMEOUT_MS);
        talonSrxColorWheel.config_kI(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);
        talonSrxColorWheel.config_kD(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);

        // Initialize current encoder position as zero
        talonSrxColorWheel.setSelectedSensorPosition(0, PID_LOOP_PRIMARY, TIMEOUT_MS);
        SensorCollection sensorCol = talonSrxColorWheel.getSensorCollection();
        int absolutePosition = sensorCol.getPulseWidthPosition();
        absolutePosition &= 0xFFF;
        if (SENSOR_PHASE)
            absolutePosition *= -1;
        if (MOTOR_INVERT)
            absolutePosition *= -1;
        // Set the quadrature (relative) sensor to match absolute
        talonSrxColorWheel.setSelectedSensorPosition(absolutePosition, PID_LOOP_PRIMARY, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the Conveyor motor
    public void stopWheel() {
        if (m_disabled)
            return;
        talonSrxColorWheel.stopMotor();
    }

    // Move the Conveyor motor
    public void spinWheel() {
        if (m_disabled)
            return;
        talonSrxColorWheel.set(0.2);
    }

    // Rotates the color wheel 360 degrees
    public void rotateWheel() {
        int distance = 100;
        int spoolDiameter = 4;
        double ticks = EncoderUtils.translateDistanceToTicks(distance, spoolDiameter, 16);
        Logger.info("ColorWheel -> Motion Magic to OPEN: " + distance + " feet, " + ticks + " ticks");

        if (m_disabled)
            return;
        talonSrxColorWheel.set(ControlMode.MotionMagic, ticks);
    }

}
