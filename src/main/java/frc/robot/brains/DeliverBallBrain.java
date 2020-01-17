
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

public class DeliverBallBrain {

    //----------------//
    // Default Values //
    //----------------//

  public static double deliverRightWheelVelocityDefault = 1;
  public static double deliverLeftWheelVelocityDefault = 1;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//
  public static   NetworkTableEntry deliverRightWheelVelocityEntry;
  public static   NetworkTableEntry deliverLeftWheelVelocityEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//
    public static double getRightWheelVelocity() {
        return deliverRightWheelVelocityEntry.getDouble(deliverRightWheelVelocityDefault);
    }

    public static double getLeftWheelVelocity() {
        return deliverLeftWheelVelocityEntry.getDouble(deliverLeftWheelVelocityDefault);
    }






}





