
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxPickup;

// Pickup subsystem, for picking up balls
public class Pickup extends SubsystemBase {

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public Pickup() {
        Logger.setup("Constructing Subsystem: Pickup...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxPickup == null);
        if (m_disabled) {
            Logger.error("Pickup devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        talonSrxPickup.configFactoryDefault();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the Pickup motor
    public void stop() {
        if (m_disabled) return;
        talonSrxPickup.stopMotor();
    }

    // Spin Pickup motor
    public void spin() {
        if (m_disabled) return;
        talonSrxPickup.set(0.5);
    }

}
