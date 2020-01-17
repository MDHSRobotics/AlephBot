package frc.robot.commands.DeliverBall;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.SubsystemDevices;
import frc.robot.consoles.Logger;

public class DeliverBall extends CommandBase {

    public DeliverBall() {

    //     // Add given subsystem requirement
   // m_deliverball = Deliverball;

    // }
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootBall...");
    }

    @Override
    public void execute() {
        SubsystemDevices.talonSRXDeliveryLeftWheel.set(0.2);
        SubsystemDevices.talonSRXDeliveryRightWheel.set(0.2);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: ShootBall...");
        } else {
            Logger.ending("Ending Command: ShootBall...");
        }

    }
}
