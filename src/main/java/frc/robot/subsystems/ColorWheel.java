
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.talonSrxColorWheel;

// Conveyor subsystem, for moving a ball up to the shooter
public class ColorWheel extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

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

}
