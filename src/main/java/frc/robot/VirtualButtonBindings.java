
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the virtual button->command bindings for testing the robot.
public class VirtualButtonBindings {

    // Configure "primary" virtual buttons
    public static void configurePrimary() {
        Logger.setup("Configure Virtual Buttons -> Primary Virtual Controller...");

        // Pickup
        VirtualControllers.primary.btnA.whileActiveContinuous(BotCommands.spinPickup);

        // Conveyor
        VirtualControllers.primary.btnY.whileActiveContinuous(BotCommands.moveConveyor);

        // Shooter
        VirtualControllers.primary.btnX.whileActiveContinuous(BotCommands.shootBall);
    }

}
