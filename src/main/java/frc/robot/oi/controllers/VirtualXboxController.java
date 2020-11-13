
package frc.robot.oi.controllers;

import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.oi.controllers.DPadButton.Direction;

// A virtual xbox controller for simulating analog inputs.
public class VirtualXboxController extends GenericHID {

    public double xLeft;
    public double yLeft;
    public double xRight;
    public double yRight;
    public boolean dpadActive;
    public Direction dpadDirection;
    public double triggerAxisLeft;
    public double triggerAxisRight;

    public VirtualXboxController() {
        this(-1);
    }

    private VirtualXboxController(int port) {
        super(port);
        resetInputs();
    }

    // resets all inouts
    public void resetInputs() {
        xLeft = 0.0;
        yLeft = 0.0;
        xRight = 0.0;
        yRight = 0.0;
        dpadActive = false;
        dpadDirection = Direction.UP;
        triggerAxisLeft = 0.0;
        triggerAxisRight = 0.0;
    }

    //Gets the X value
    @Override
    public double getX(Hand hand) {
        switch (hand) {
            case kLeft: return xLeft;
            case kRight: return xRight;
            default: return xRight;
        }
    }

    // Gets the Y value on controller
    @Override
    public double getY(Hand hand) {
        switch (hand) {
            case kLeft: return yLeft;
            case kRight: return yRight;
            default: return yRight;
        }
    }

    // creates dpad direction and its degree
    @Override
    public int getPOV(int pov) {
        if (!dpadActive) return -1;
        return dpadDirection.degrees;
    }

    public double getTriggerAxis(Hand hand) {
        switch (hand) {
            case kLeft: return triggerAxisLeft;
            case kRight: return triggerAxisRight;
            default: return triggerAxisRight;
        }
    }

}
