
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
    public static WPI_TalonSRX talonSrxConveyor = new WPI_TalonSRX(9);
    public static WPI_TalonSRX talonSrxPickup = new WPI_TalonSRX(9); // 1 motor

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        initConveyorDevices();
        initPickupDevices();
    }

    // Conveyor
    private static void initConveyorDevices() {
        boolean talonSrxConveyorIsConnected = isConnected(talonSrxConveyor);

        if (!talonSrxConveyorIsConnected) {
            talonSrxConveyor = null;
            Logger.error("Conveyor talon is not connected! Disabling...");
        }
    }

    // Pickup
    private static void initPickupDevices() {
        boolean talonSrxPickupIsConnected = isConnected(talonSrxPickup);

        if (!talonSrxPickupIsConnected) {
            talonSrxPickup = null;
            Logger.error("Pickup talon is not connected! Disabling...");
        }
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}
