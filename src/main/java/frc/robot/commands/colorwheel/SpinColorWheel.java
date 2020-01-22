
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Pickup;

// This command spins the Pickup motor
public class SpinColorWheel extends CommandBase {

    private Pickup m_pickup;

    public SpinPickup(Pickup pickup) {
        Logger.setup("Constructing Command: SpinPickup...");

        // Add given subsystem requirements
        m_pickup = pickup;
        addRequirements(m_pickup);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinPickup...");
    }

    @Override
    public void execute() {
        m_pickup.spin();
    }

    // This command ends immediately
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: SpinPickup...");
        } else {
            Logger.ending("Ending Command: SpinPickup...");
        }

        m_pickup.stop();
    }

}
