
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Deliverball.DeliverBall;
import frc.robot.commands.Deliverball.DeliveryStop;
import frc.robot.commands.lighter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    public static CycleLights cycleLights;
    public static DeliverBall deliverBall;
    public static DeliveryStop deliveryStop;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        cycleLights = new CycleLights(BotSubsystems.lighter);
        deliverBall = new DeliverBall(BotSubsystems.delivery);
        deliveryStop = new DeliveryStop(BotSubsystems.delivery);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}
