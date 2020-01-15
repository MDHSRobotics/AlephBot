package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.EncoderConstants;
import frc.robot.Constants.TalonConstants;
import frc.robot.EncoderUtils;
import frc.robot.SubsystemDevices;
//import frc.robot.brains.ConveyorBrain;
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
