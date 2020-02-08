
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static Conveyor conveyor;
    public static DiffDriver diffDriver;
    public static Lighter lighter;
    public static Pickup pickup;
    public static Shooter shooter;
    public static Wheeler wheeler;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        conveyor = new Conveyor();
        diffDriver = new DiffDriver();
        lighter = new Lighter();
        pickup = new Pickup();
        shooter = new Shooter();
        wheeler = new Wheeler();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {
        // Conveyor
        Logger.setup("Conveyor DefaultCommand -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        // DiffDriver
        Logger.setup("DiffDriver DefaultCommand -> DriveDifferentialTank...");
        diffDriver.setDefaultCommand(BotCommands.driveDifferentialTank);

        // Pickup
        Logger.setup("Pickup DefaultCommand -> StopPickup...");
        pickup.setDefaultCommand(BotCommands.stopPickup);

        // Shooter
        Logger.setup("Shooter DefaultCommand -> StopShooter...");
        shooter.setDefaultCommand(BotCommands.stopShooter);

        // Wheeler
        Logger.setup("ColorWheel DefaultCommand -> StopColorWheel...");
        wheeler.setDefaultCommand(BotCommands.stopColorWheel);
    }

    // Set all the subsystem "test" default commands
    public static void setTestDefaultCommands() {
    }

}
