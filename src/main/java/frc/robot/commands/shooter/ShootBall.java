package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

public class ShootBall extends CommandBase {
    private Shooter m_delivery;

    public ShootBall(Shooter delivery) {
         Logger.setup("Constructing Command: ShootBall...");

    // Add given subsystem requirement
    m_delivery = delivery;
    addRequirements(m_delivery);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootBall...");
    }

    @Override
    public void execute() {
        m_delivery.spinWheels();
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

        m_delivery.stop();
    }
}
