
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.Constants.EncoderConstants;
import frc.robot.Constants.TalonConstants;
import frc.robot.EncoderUtils;
import frc.robot.SubsystemDevices;

// Pickup subsystem, for picking up balls
public class Pickup extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Pickup() {
        Logger.setup("Constructing Subsystem: Pickup...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.talonSrxPickup == null);
        if (m_disabled) {
            Logger.error("Pickup devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        SubsystemDevices.talonSrxPickup.configFactoryDefault();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the Pickup motor
    public void stop() {
        if (m_disabled) return;
        SubsystemDevices.talonSrxPickup.stopMotor();
    }

    // Spin Pickup motor
    public void spin() {
        if (m_disabled) return;
        SubsystemDevices.talonSrxPickup.set(0.5);
    }

}
