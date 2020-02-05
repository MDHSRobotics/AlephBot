
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.VirtualControllers;

// Configures all the virtual button->command bindings for testing the robot.
public class VirtualButtonBindings {

    // Configure "primary" virtual buttons
    public static void configurePrimary() {
        Logger.setup("Configure Virtual Buttons -> Primary Virtual Controller...");

        // Shooter
        VirtualControllers.primary.btnX.whileActiveContinuous(BotCommands.shootBall);

        // Pickup
        VirtualControllers.primary.btnA.whileActiveContinuous(BotCommands.spinPickup);
    }

    // Configure "secondary" virtual buttons
    public static void configureSecondary() {
        Logger.setup("Configure Virtual Buttons -> Secondary Virtual Controller...");

        // Conveyor
        VirtualControllers.secondary.btnBumperLeft.whileActiveContinuous(BotCommands.moveConveyor);

    }

}
