
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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
    static WPI_TalonSRX talonSrxDiffWheelFrontLeft = new WPI_TalonSRX(12); // 1 motor
    static WPI_TalonSRX talonSrxDiffWheelRearLeft = new WPI_TalonSRX(4); // 1 motor
    static WPI_TalonSRX talonSrxDiffWheelFrontRight = new WPI_TalonSRX(14); // 1 motor
    static WPI_TalonSRX talonSrxDiffWheelRearRight = new WPI_TalonSRX(13); // 1 motor

    static WPI_TalonSRX talonSrxConveyor = new WPI_TalonSRX(9);

    static WPI_TalonSRX talonSrxPickup = new WPI_TalonSRX(2); // 1 motor

    static WPI_TalonSRX talonSrxShooterLeftWheel = new WPI_TalonSRX(12);
    static WPI_TalonSRX talonSrxShooterRightWheel = new WPI_TalonSRX(14);

    static WPI_TalonSRX talonSrxWheeler = new WPI_TalonSRX(5); // 1 motor

    ////////////////////////
    // Drive Declarations //
    ////////////////////////

    public static DifferentialDrive diffDrive;

    /////////////////////
    // Initializations //
    /////////////////////

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing subsystem Devices...");

        initConveyorDevices();
        initDiffDriverDevices();
        initPickupDevices();
        initShooterDevices();
        initWheelerDevices();
    }

    // Conveyor
    private static void initConveyorDevices() {
        boolean talonSrxConveyorIsConnected = DeviceUtils.isConnected(talonSrxConveyor);
        if (!talonSrxConveyorIsConnected) {
            talonSrxConveyor = null;
            Logger.problem("Conveyor talon is not connected! Disabling...");
        }
    }

    // Differential Drive
    private static void initDiffDriverDevices() {
        boolean talonSrxDiffWheelFrontLeftIsConnected = DeviceUtils.isConnected(talonSrxDiffWheelFrontLeft);
        boolean talonSrxDiffWheelFrontRightIsConnected = DeviceUtils.isConnected(talonSrxDiffWheelFrontRight);
        boolean talonSrxDiffWheelRearLeftIsConnected = DeviceUtils.isConnected(talonSrxDiffWheelRearLeft);
        boolean talonSrxDiffWheelRearRightIsConnected = DeviceUtils.isConnected(talonSrxDiffWheelRearRight);

        boolean talonsAreConnected = true;
        if (!talonSrxDiffWheelFrontLeftIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelFrontLeft talon is not connected!");
        }
        if (!talonSrxDiffWheelFrontRightIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelFrontRight talon is not connected!");
        }
        if (!talonSrxDiffWheelRearLeftIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelRearLeft talon is not connected!");
        }
        if (!talonSrxDiffWheelRearRightIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelRearRight talon is not connected!");
        }

        if (!talonsAreConnected) {
            Logger.problem("DiffDriver devices not all connected! Disabling...");
            talonSrxDiffWheelFrontLeft = null;
            talonSrxDiffWheelFrontRight = null;
            talonSrxDiffWheelRearLeft = null;
            talonSrxDiffWheelRearRight = null;
        } else {
            diffDrive = new DifferentialDrive(talonSrxDiffWheelFrontLeft, talonSrxDiffWheelFrontRight);
        }
    }

    // Pickup
    private static void initPickupDevices() {
        boolean talonSrxPickupIsConnected = DeviceUtils.isConnected(talonSrxPickup);
        if (!talonSrxPickupIsConnected) {
            talonSrxPickup = null;
            Logger.problem("Pickup talon is not connected! Disabling...");
        }
    }

    // Shooter
    private static void initShooterDevices() {
        boolean talonSRXShooterLeftWheelIsConnected = DeviceUtils.isConnected(talonSrxShooterLeftWheel);
        boolean talonSRXShooterRightWheelIsConnected = DeviceUtils.isConnected(talonSrxShooterRightWheel);

        boolean talonsAreConnected = true;
        if (!talonSRXShooterLeftWheelIsConnected) {
            talonsAreConnected = false;
            Logger.problem("ShooterLeftWheel talon is not connected!");
        }
        if (!talonSRXShooterRightWheelIsConnected) {
            talonsAreConnected = false;
            Logger.problem("ShooterRightWheel talon is not connected!");
        }

        if (!talonsAreConnected) {
            Logger.problem("Shooter devices not all connected! Disabling...");
            talonSrxShooterLeftWheel = null;
            talonSrxShooterRightWheel = null;
        }
    }

    // Wheeler
    private static void initWheelerDevices() {
        boolean talonSrxWheelerIsConnected = DeviceUtils.isConnected(talonSrxWheeler);
        if (!talonSrxWheelerIsConnected) {
            talonSrxWheeler = null;
            Logger.problem("Wheeler talon is not connected! Disabling...");
        }
    }

}
