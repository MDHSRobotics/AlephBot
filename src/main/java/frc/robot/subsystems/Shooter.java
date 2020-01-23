package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

// Subsystem for shooting balls
public class Shooter extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        m_disabled = (Devices.talonSRXShooterLeftWheel == null) || (Devices.talonSRXShooterRightWheel == null);

        if (m_disabled) {
            Logger.error("Shoooter devices not initialized! Disabling subsystem...");
            return;
        }
        //configure the subsystem devices
        Devices.talonSRXShooterLeftWheel.configFactoryDefault();
        Devices.talonSRXShooterRightWheel.configFactoryDefault();
    }

    // Stop the shooter motor
    public void stop() {
        if (m_disabled) return;
        Devices.talonSRXShooterLeftWheel.stopMotor();
        Devices.talonSRXShooterRightWheel.stopMotor();
    }

    public void spinWheels() {
        if (m_disabled) return;
        Devices.talonSRXShooterLeftWheel.set(0.2);
        Devices.talonSRXShooterRightWheel.set(-0.2);
    }

}
