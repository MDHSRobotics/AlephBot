
package frc.robot.oi.positions;

import frc.robot.oi.controllers.XboxControllerContainer;

// The position values obtained from xbox triggers
public class TriggerAxisPosition {

    public double leftTriggerPosition = 0;
    public double rightTriggerPosition = 0;

    public TriggerAxisPosition() {
    }

    public TriggerAxisPosition(double leftTrigger, double rightTrigger) {
        leftTriggerPosition = leftTrigger;
        rightTriggerPosition = rightTrigger;
    }

    // Gets the xbox trigger positions
    public static TriggerAxisPosition getTriggerPositions(XboxControllerContainer controller) {
        TriggerAxisPosition pos = controller.getTriggerPositions();
        return pos;
    }

}
