
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxWheeler;

// Wheeler subsystem, for spinning the color wheel
public class Wheeler extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

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

}
