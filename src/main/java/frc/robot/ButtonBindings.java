
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure "primary" xbox buttons
    public static void configurePrimary() {
        Logger.setup("Configure Buttons -> Primary Controller...");

        // Pickup
        BotControllers.primary.btnA.whileHeld(BotCommands.spinPickup);

        // Conveyor
        BotControllers.primary.btnY.whenPressed(BotCommands.moveConveyor);

        // Shooter
        BotControllers.primary.btnX.whileHeld(BotCommands.shootBall);
        ControlDevices.driveXboxBtnA.whileHeld(BotCommands.spinPickup);
        ControlDevices.driveXboxBtnB.whenPressed(BotCommands.cycleLights);
        ControlDevices.driveXboxBtnY.whenPressed(BotCommands.moveConveyor);
        ControlDevices.driveXboxBtnBumperLeft.whenPressed(BotCommands.spinColorWheel);
        ControlDevices.driveXboxBtnBumperRight.whileHeld(BotCommands.switchMode);
        ControlDevices.driveXboxBtnX.whenPressed(BotCommands.rotateWheel);

    }

}
