package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Subsystem for shooting balls
public class Shooter extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        m_disabled = (SubsystemDevices.talonSRXShooterLeftWheel == null) && (SubsystemDevices.talonSRXShooterRightWheel == null);

        if (m_disabled) {
            Logger.error("Shoooter devices not initialized! Disabling subsystem...");
            return;
        }
        //configure the subsystem devices
        SubsystemDevices.talonSRXShooterLeftWheel.configFactoryDefault();
        SubsystemDevices.talonSRXShooterRightWheel.configFactoryDefault();
    }

    // Stop the shooter motor
    public void stop() {
        if (m_disabled) return;
        SubsystemDevices.talonSRXShooterLeftWheel.stopMotor();
        SubsystemDevices.talonSRXShooterRightWheel.stopMotor();
    }

    public void spinWheels() {
        if (m_disabled) return;
        SubsystemDevices.talonSRXShooterLeftWheel.set(0.2);
        SubsystemDevices.talonSRXShooterRightWheel.set(-0.2);
    }

}
