
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.auto.*;
import frc.robot.commands.conveyor.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.lighter.*;
import frc.robot.commands.pickup.*;
import frc.robot.commands.shooter.*;
import frc.robot.commands.wheeler.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Autonomous
    public static AutoDriveForward autoDriveForward;
    public static AutoDriveForwardShoot autoDriveForwardShoot;

    // Conveyor
    public static MoveConveyor moveConveyor;
    public static StopConveyor stopConveyor;

    // DiffDriver
    public static DriveDiffTank driveDifferentialTank;

    // Lighter
    public static CycleLights cycleLights;

    // Pickup
    public static SpinPickup spinPickup;
    public static StopPickup stopPickup;

    // Shooter
    public static ShootBall shootBall;
    public static StopShooter stopShooter;

    // Wheeler
    public static SpinColorWheel spinColorWheel;
    public static StopColorWheel stopColorWheel;
    public static TwirlWheelThreeTimes twirlWheel;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        autoDriveForward = new AutoDriveForward(BotSubsystems.diffDriver);
        autoDriveForwardShoot = new AutoDriveForwardShoot(BotSubsystems.diffDriver);

        // Conveyor
        moveConveyor = new MoveConveyor(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);

        // DiffDriver
        driveDifferentialTank = new DriveDiffTank(BotSubsystems.diffDriver);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Pickup
        spinPickup = new SpinPickup(BotSubsystems.pickup);
        stopPickup = new StopPickup(BotSubsystems.pickup);

        // Shooter
        shootBall = new ShootBall(BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);

        // Wheeler
        spinColorWheel = new SpinColorWheel(BotSubsystems.wheeler);
        stopColorWheel = new StopColorWheel(BotSubsystems.wheeler);
        twirlWheel = new TwirlWheelThreeTimes(BotSubsystems.wheeler);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return autoDriveForwardShoot;
    }

}
