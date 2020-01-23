
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.utils.DeviceUtils;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // Relays
    static Relay relayLighter = new Relay(1);

    // TalonSRX
    static WPI_TalonSRX talonSRXShooterLeftWheel = new WPI_TalonSRX(2);
    static WPI_TalonSRX talonSRXShooterRightWheel = new WPI_TalonSRX(4);

    ////////////////////////
    // Drive Declarations //
    ////////////////////////

    // TODO: Add the appropriate drives

    /////////////////////
    // Initializations //
    /////////////////////

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing subsystem Devices...");

        //Initializes the devices
        initShooterDevices();
    }

    // Shooter
    private static void initShooterDevices() {
        boolean talonSRXShooterLeftWheelIsConnected = DeviceUtils.isConnected(talonSRXShooterLeftWheel);
        boolean talonSRXShooterRightWheelIsConnected = DeviceUtils.isConnected(talonSRXShooterRightWheel);

        if (!talonSRXShooterLeftWheelIsConnected) {
            Logger.error("Shooter left wheel talon not connnected. Disabling...");
            talonSRXShooterLeftWheel = null;
        }

        if (!talonSRXShooterRightWheelIsConnected) {
            Logger.error("Shooter right wheel talon not connnected. Disabling...");
            talonSRXShooterRightWheel = null;
        }
    }

}
