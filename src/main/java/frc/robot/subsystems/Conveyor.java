
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Conveyor subsystem, for moving a ball up to the shooter
public class Conveyor extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Conveyor...");
    }

    public void conveyor() {
        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.talonSrxConveyor == null);
        if (m_disabled) {
            Logger.error("Conveyor devices not initialized! Disabling subsystem...");
            return;
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the Conveyor motor
    public void stop() {
        if (m_disabled) return;
        SubsystemDevices.talonSrxConveyor.stopMotor();
    }

    // Move the Conveyor motor
    public void move() {
        if (m_disabled) return;
        SubsystemDevices.talonSrxConveyor.set(0.2);
    }

}
