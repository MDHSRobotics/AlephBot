package frc.robot.commands.Deliverball;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Delivery;

// This command stops the Delivery motor
public class DeliveryStop extends CommandBase {

    private Delivery m_delivery;

    public DeliveryStop(Delivery delivery) {
        Logger.setup("Constructing Command: DeliveryStop...");
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DeliveryStop...");
    }

    @Override
    public void execute() {
        m_delivery.stop();
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: DeliveryStop...");
        } else {
            Logger.ending("Ending Command: DeliveryStop...");
        }

        m_delivery.stop();
    }

}