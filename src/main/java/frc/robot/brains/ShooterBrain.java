
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

public class ShooterBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double shooterLeftWheelPowerDefault = 1;
    public static double shooterRightWheelPowerDefault = 1;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry shooterLeftWheelPowerEntry;
    public static NetworkTableEntry shooterRightWheelPowerEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getShooterLeftWheelPower() {
        return shooterLeftWheelPowerEntry.getDouble(shooterLeftWheelPowerDefault);
    }

    public static double getShooterRightWheelPower() {
        return shooterRightWheelPowerEntry.getDouble(shooterRightWheelPowerDefault);
    }

}
