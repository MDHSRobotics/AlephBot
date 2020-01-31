
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.colorwheel.DetectColor;
import frc.robot.commands.colorwheel.SpinColorWheel;
import frc.robot.commands.colorwheel.StopColorWheel;
import frc.robot.commands.conveyor.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.lighter.*;
import frc.robot.commands.pickup.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

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

    // Color Wheel
    public static SpinColorWheel spinColorWheel;
    public static StopColorWheel stopColorWheel;
    public static DetectColor detectColor;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

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

        // Color Wheel
        spinColorWheel = new SpinColorWheel(BotSubsystems.colorwheel);
        stopColorWheel = new StopColorWheel(BotSubsystems.colorwheel);
        detectColor = new DetectColor(BotSubsystems.targetColor);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}
