
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DeliverBall.Deliverball;
import frc.robot.commands.lighter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    public static CycleLights cycleLights;
    public static Deliverball deliverball;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        cycleLights = new CycleLights(BotSubsystems.lighter);
        deliverball = new Deliverball(BotSubsystems.delivery);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}
