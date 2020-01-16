package frc.robot.commands.Deliverball;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;

public class Deliverball extends CommandBase {

    // TODO: Make these constructor parameters. Use overloading for these default values.
    // public ShootBall(Deliverball shoot) {
    //     Logger.setup("Constructing Command: ShootBall...");

    //     // Add given subsystem requirements

    // }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootBall...");
    }

    @Override
    public void execute() {

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

        // m_shoot.stop();
    }
}
