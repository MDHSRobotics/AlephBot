
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped subsystem components, and utility methods.
// IMPORTANT: It is imperative that ONLY subsystems control any interactive device.
// Also, only ONE subsystem should control any given device.
public class SubsystemDevices {

    // Relays
    public static Relay relayLighter = new Relay(1);

    // Motor Controllers
    // TODO: Add the appropriate motor controllers
    public static WPI_TalonSRX talonSRXDeliveryLeftWheel = new WPI_TalonSRX(1);
    public static WPI_TalonSRX talonSRXDeliveryRightWheel = new WPI_TalonSRX(2);

    // Drives
    // TODO: Add the appropriate drives


    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        //Initializes the devices
        initDeliveryDevices();
    }

    private static void initDeliveryDevices() {
        boolean talonSRXDeliveryLeftIsConnected = isConnected(talonSRXDeliveryLeftWheel);
        boolean talonSRXDeliveryRightIsConnected = isConnected(talonSRXDeliveryRightWheel);

        if (!talonSRXDeliveryLeftIsConnected) {
            Logger.error("Delivery talons not connnected. Disabling...");
            talonSRXDeliveryLeftWheel = null;
        }
        if (!talonSRXDeliveryRightIsConnected) {
            Logger.error("Delivery talons not connnected. Disabling...");
            talonSRXDeliveryRightWheel = null;
        }
    }
    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}
