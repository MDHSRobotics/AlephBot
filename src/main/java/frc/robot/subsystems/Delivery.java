package frc.robot.subsystems;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Pulley subsystem for lifting the back end of robot up above a platform
public class Delivery extends SubsystemDevices {

    // Motor constants
    //private final double SECONDS_FROM_NEUTRAL_TO_FULL = 0;
    //private final int TIMEOUT_MS = 10;

    // The Talon connection state, to prevent watchdog warnings during testing
    private boolean m_talonsAreConnected = true;

    //The delivery state, to toggle the delivery subsystem
    public int speed;

    public Delivery() {
        Logger.setup("Constructing Subsystem: Delivery...");

        if (!m_talonsAreConnected) {
            Logger.error("Pulley talons not all connected! Disabling Delivery...");
        }/* else {
            SubsystemDevices.talonSRXDeliveryLeftWheel.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        }*/


    }

    // Stop the delivery motor
    public void stop() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSRXDeliveryLeftWheel.stopMotor();
        SubsystemDevices.talonSRXDeliveryRightWheel.stopMotor();
    }

    // Set the Delivery motor speed explicitly
    public void setSpeed(final double speed) {
        if (!m_talonsAreConnected)
            return;
    }

    //---------//
    // Testing //
    //---------//

    public void testMotors() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSRXDeliveryLeftWheel.set(0.2);
        SubsystemDevices.talonSRXDeliveryRightWheel.set(0.2);
    }

}
