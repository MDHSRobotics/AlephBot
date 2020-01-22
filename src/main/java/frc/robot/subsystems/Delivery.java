package frc.robot.subsystems;

import frc.robot.consoles.Logger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SubsystemDevices;

// Pulley subsystem for lifting the back end of robot up above a platform
public class Delivery extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Delivery() {
        Logger.setup("Constructing Subsystem: Delivery...");

        m_disabled = (SubsystemDevices.talonSRXDeliveryLeftWheel == null) && (SubsystemDevices.talonSRXDeliveryRightWheel == null);

        if (m_disabled) {
            Logger.error("Delivey devices not initialized! Disabling subsystem...");
            return;
        }
        //configure the subsystem devices
        SubsystemDevices.talonSRXDeliveryLeftWheel.configFactoryDefault();
        SubsystemDevices.talonSRXDeliveryRightWheel.configFactoryDefault();
    }

    // Stop the delivery motor
    public void stop() {
        if (m_disabled) return;
        SubsystemDevices.talonSRXDeliveryLeftWheel.stopMotor();
        SubsystemDevices.talonSRXDeliveryRightWheel.stopMotor();
    }

    public void spinWheels() {
        if (m_disabled) return;
        SubsystemDevices.talonSRXDeliveryLeftWheel.set(0.2);
        SubsystemDevices.talonSRXDeliveryRightWheel.set(-0.2);
    }

}
