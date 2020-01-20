
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static Conveyor conveyor;
    public static DiffDriver diffDriver;
    public static Lighter lighter;
    public static Pickup pickup;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        conveyor = new Conveyor();
        diffDriver = new DiffDriver();
        lighter = new Lighter();
        pickup = new Pickup();
    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        Logger.setup("Conveyor DefaultCommand -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        Logger.setup("DiffDriver DefaultCommand -> DiffDriver...");
        diffDriver.setDefaultCommand(BotCommands.diffDriver);

        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);

        Logger.setup("Pickup DefaultCommand -> StopPickup...");
        pickup.setDefaultCommand(BotCommands.stopPickup);
    }

}
