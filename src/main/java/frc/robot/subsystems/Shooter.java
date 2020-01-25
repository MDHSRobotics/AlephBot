package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSRXShooterLeftWheel;
import static frc.robot.subsystems.Devices.talonSRXShooterRightWheel;

// Subsystem for shooting balls
public class Shooter extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        m_disabled = (talonSRXShooterLeftWheel == null) || (talonSRXShooterRightWheel == null);

        if (m_disabled) {
            Logger.error("Shoooter devices not initialized! Disabling subsystem...");
            return;
        }
        //configure the subsystem devices
        talonSRXShooterLeftWheel.configFactoryDefault();
        talonSRXShooterRightWheel.configFactoryDefault();
    }

    // Stop the shooter motor
    public void stop() {
        if (m_disabled) return;
        talonSRXShooterLeftWheel.stopMotor();
        talonSRXShooterRightWheel.stopMotor();
    }

    public void spinWheels() {
        if (m_disabled) return;
        talonSRXShooterLeftWheel.set(0.8);
        talonSRXShooterRightWheel.set(0.8);
    }

}
