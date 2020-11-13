package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxShooterLeftWheel;
import static frc.robot.subsystems.Devices.talonSrxShooterRightWheel;

// Subsystem for shooting balls
public class Shooter extends SubsystemBase {

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        m_disabled = (talonSrxShooterLeftWheel == null) || (talonSrxShooterRightWheel == null);

        if (m_disabled) {
            Logger.problem("Shoooter devices not initialized! Disabling subsystem...");
            return;
        }
        // Configures the subsystem devices
        talonSrxShooterLeftWheel.configFactoryDefault();
        talonSrxShooterRightWheel.configFactoryDefault();
    }

    // Stops the shooter motor
    public void stop() {
        if (m_disabled) return;
        talonSrxShooterLeftWheel.stopMotor();
        talonSrxShooterRightWheel.stopMotor();
    }

    public void spinWheels() {
        if (m_disabled) return;
        talonSrxShooterLeftWheel.set(0.8);
        talonSrxShooterRightWheel.set(0.8);
    }

}
