package frc.robot.subsystems;

//import frc.robot.commands.idle.;
import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Pulley subsystem for lifting the back end of robot up above a platform
public class Delivery extends SubsystemDevices {

    // Motor constants
    private final double SECONDS_FROM_NEUTRAL_TO_FULL = 0;
    private final int TIMEOUT_MS = 10;

    // The Talon connection state, to prevent watchdog warnings during testing
    private boolean m_talonsAreConnected = false;

    public Delivery() {
        Logger.setup("Constructing Subsystem: Deliver...");

        final boolean talonSRXDeliveryWheelIsConnected = SubsystemDevices.isConnected(SubsystemDevices.talonSRXDeliveryWheel);
        m_talonsAreConnected = (talonSRXDeliveryWheelIsConnected);

        if (!m_talonsAreConnected) {
            Logger.error("Pulley talons not all connected! Disabling Delivery...");
        } else {
            SubsystemDevices.talonSRXDeliveryWheel.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        }

    }

    // @Override
    // public void initDeliveryCommand() {
    //     Logger.setup("Initializing Pulley DefaultCommand -> BackStop...");

  //setDefaultCommand(new DeliveryStop());
    //}

    // Stop the Pulley motor
    public void stop() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSRXDeliveryWheel.stopMotor();
    }

    // Set the Pulley motor speed explicitly
    public void setSpeed(final double speed) {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSRXDeliveryWheel.set(speed);
    }

    //---------//
    // Testing //
    //---------//

    public void testMotors() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSRXDeliveryWheel.set(0.2);
    }

}