
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.auto.*;
import frc.robot.commands.conveyor.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.lighter.*;
import frc.robot.commands.pickup.*;
import frc.robot.commands.shooter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Autonomous
    public static AutoPeriod autoPeriod;

    // Conveyor
    public static MoveConveyor moveConveyor;
    public static StopConveyor stopConveyor;

    // DiffDriver
    public static DriveDifferentialTank driveDifferentialTank;

    // Lighter
    public static CycleLights cycleLights;

    // Pickup
    public static SpinPickup spinPickup;
    public static StopPickup stopPickup;

    // Shooter
    public static ShootBall shootBall;
    public static StopShooter stopShooter;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        autoPeriod = new AutoPeriod(BotSubsystems.diffDriver);

        // Conveyor
        moveConveyor = new MoveConveyor(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);

        // DiffDriver
        driveDifferentialTank = new DriveDifferentialTank(BotSubsystems.diffDriver);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Pickup
        spinPickup = new SpinPickup(BotSubsystems.pickup);
        stopPickup = new StopPickup(BotSubsystems.pickup);

        // Shooter
        shootBall = new ShootBall(BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return autoPeriod;
    }

}
