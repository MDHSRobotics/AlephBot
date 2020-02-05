
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Check controllers and configure button bindings
    public static void configure() {
        Logger.setup("Configuring ButtonBindings...");

        // Primary Controller
        if (!BotControllers.primary.isConnected()) {
            Logger.error("Primary controller not plugged in!");
        } else {
            configurePrimaryButtons();
        }
    }

    // Configure "primary" xbox buttons
    public static void configurePrimaryButtons() {
        Logger.setup("Configure Buttons -> Primary Controller...");

        BotControllers.primary.btnDpad.whileHeld(BotCommands.driveDifferentialTank);
        BotControllers.primary.btnA.whileHeld(BotCommands.spinPickup);
        BotControllers.primary.btnX.whileHeld(BotCommands.shootBall);
        BotControllers.primary.btnY.whenPressed(BotCommands.moveConveyor);
    }

}
