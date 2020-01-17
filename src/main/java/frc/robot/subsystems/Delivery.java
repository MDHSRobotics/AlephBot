package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.BotCommands;
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

        final boolean talonSRXDeliveryWheelIsConnected = SubsystemDevices.isConnected(SubsystemDevices.talonSRXDeliveryWheel1);
        m_talonsAreConnected = (talonSRXDeliveryWheelIsConnected);

        if (!m_talonsAreConnected) {
            Logger.error("Pulley talons not all connected! Disabling Delivery...");
        } else {
            SubsystemDevices.talonSRXDeliveryWheel1.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
            SubsystemDevices.talonSRXDeliveryWheel2.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        }

    }

    public void initDefaultCommand() {
    Logger.setup("Initializing Delivery DefaultCommand -> DeliveryStop...");

    setDefaultCommand(new DeliveryStop());
    }

    // Stop the delivery motor
    public void stop() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSRXDeliveryWheel1.stopMotor();
        SubsystemDevices.talonSRXDeliveryWheel2.stopMotor();
    }

    // Set the Delivery motor speed explicitly
    public void setSpeed(final double speed) {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSRXDeliveryWheel1.set(speed);
        SubsystemDevices.talonSRXDeliveryWheel2.set(speed);
    }
}