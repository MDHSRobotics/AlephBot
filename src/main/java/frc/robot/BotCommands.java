
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.lighter.*;
import frc.robot.commands.shooter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Lighter
    public static CycleLights cycleLights;

    // Shooter
    public static ShootBall shootBall;
    public static StopShooter stopShooter;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Shooter
        shootBall = new ShootBall(BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}
