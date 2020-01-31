
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;
import frc.robot.sensors.pixy.*;


// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static Conveyor conveyor;
    public static DiffDriver diffDriver;
    public static Lighter lighter;
    public static Pickup pickup;
    public static ColorWheel colorwheel;
    public static TargetColor targetColor;
    public static ColorMode colorMode;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        conveyor = new Conveyor();
        diffDriver = new DiffDriver();
        lighter = new Lighter();
        pickup = new Pickup();
        colorwheel = new ColorWheel();
        targetColor = new TargetColor();
        colorMode = new ColorMode();
    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        Logger.setup("Conveyor DefaultCommand -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        Logger.setup("DiffDriver DefaultCommand -> DriveDifferentialTank...");
        diffDriver.setDefaultCommand(BotCommands.driveDifferentialTank);

        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);

        Logger.setup("Pickup DefaultCommand -> StopPickup...");
        pickup.setDefaultCommand(BotCommands.stopPickup);

        Logger.setup("ColorWheel DefaultCommand -> StopColorWheel...");
        colorwheel.setDefaultCommand(BotCommands.stopColorWheel);

        Logger.setup("TargetColor DefaultCommand -> DetectColor...");
        targetColor.setDefaultCommand(BotCommands.detectColor);
    }

}
