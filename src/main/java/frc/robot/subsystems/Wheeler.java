
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.utils.EncoderUtils;

import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.constants.TalonConstants.*;
import static frc.robot.subsystems.Devices.talonSrxWheeler;

// Wheeler subsystem, for spinning the color wheel
public class Wheeler extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    // Encoder constants
    private final boolean SENSOR_PHASE = true;
    private final boolean MOTOR_INVERT = false;

    public Wheeler() {
        Logger.setup("Constructing Subsystem: Wheeler...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxWheeler == null);
        if (m_disabled) {
            Logger.problem("Wheeler devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        talonSrxWheeler.configFactoryDefault();

        talonSrxWheeler.configPeakCurrentDuration(PEAK_AMPERAGE_DURATION, TIMEOUT_MS);
        talonSrxWheeler.configPeakCurrentLimit(PEAK_AMPERAGE, TIMEOUT_MS);
        talonSrxWheeler.configContinuousCurrentLimit(CONTINUOUS_AMPERAGE_LIMIT, TIMEOUT_MS);

        talonSrxWheeler.configNominalOutputForward(0);
        talonSrxWheeler.configNominalOutputReverse(0);
        talonSrxWheeler.configPeakOutputForward(0.5);
        talonSrxWheeler.configPeakOutputReverse(-0.5);

        talonSrxWheeler.configMotionAcceleration(3000, TIMEOUT_MS);
        talonSrxWheeler.configMotionCruiseVelocity(8000, TIMEOUT_MS);

        // Config TalonSRX Redline encoder
        talonSrxWheeler.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, PID_LOOP_PRIMARY, TIMEOUT_MS);
        talonSrxWheeler.setSensorPhase(SENSOR_PHASE);
        talonSrxWheeler.setInverted(MOTOR_INVERT);
        talonSrxWheeler.configAllowableClosedloopError(0, PID_LOOP_PRIMARY, TIMEOUT_MS);

        talonSrxWheeler.config_kF(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);
        talonSrxWheeler.config_kP(PID_LOOP_PRIMARY, 0.32, TIMEOUT_MS);
        talonSrxWheeler.config_kI(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);
        talonSrxWheeler.config_kD(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);

        // Initialize current encoder position as zero
        talonSrxWheeler.setSelectedSensorPosition(0, PID_LOOP_PRIMARY, TIMEOUT_MS);
        SensorCollection sensorCol = talonSrxWheeler.getSensorCollection();
        int absolutePosition = sensorCol.getPulseWidthPosition();
        absolutePosition &= 0xFFF;
        if (SENSOR_PHASE) absolutePosition *= -1;
        if (MOTOR_INVERT) absolutePosition *= -1;
        // Set the quadrature (relative) sensor to match absolute
        talonSrxWheeler.setSelectedSensorPosition(absolutePosition, PID_LOOP_PRIMARY, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the Wheeler motor
    public void stopWheel() {
        if (m_disabled) return;
        talonSrxWheeler.stopMotor();
    }

    // Spin the Wheeler motor
    public void spinWheel() {
        if (m_disabled) return;
        talonSrxWheeler.set(0.2);
    }

    // Spin the color wheel 360 degrees
    public void twirlWheel() {
        int distance = 100;
        int spoolDiameter = 4;
        double ticks = EncoderUtils.translateDistanceToTicks(distance, spoolDiameter, 16);
        Logger.info("Wheeler -> Motion Magic to OPEN: " + distance + " feet, " + ticks + " ticks");

        if (m_disabled) return;
        talonSrxWheeler.set(ControlMode.MotionMagic, ticks);
    }

}
