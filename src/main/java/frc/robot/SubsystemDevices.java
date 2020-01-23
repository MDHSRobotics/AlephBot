
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
    public static WPI_TalonSRX talonSRXShooterLeftWheel = new WPI_TalonSRX(2);
    public static WPI_TalonSRX talonSRXShooterRightWheel = new WPI_TalonSRX(4);

    // Drives
    // TODO: Add the appropriate drives

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        //Initializes the devices
        initShooterDevices();
    }

    private static void initShooterDevices() {
        boolean talonSRXShooterLeftWheelIsConnected = isConnected(talonSRXShooterLeftWheel);
        boolean talonSRXShooterRightWheelIsConnected = isConnected(talonSRXShooterRightWheel);

        if (!talonSRXShooterLeftWheelIsConnected) {
            Logger.error("Shooter left wheel talon not connnected. Disabling...");
            talonSRXShooterLeftWheel = null;
        }

        if (!talonSRXShooterRightWheelIsConnected) {
            Logger.error("Shooter right wheel talon not connnected. Disabling...");
            talonSRXShooterRightWheel = null;
        }
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}
