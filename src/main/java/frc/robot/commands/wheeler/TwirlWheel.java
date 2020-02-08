
package frc.robot.commands.wheeler;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Wheeler;

// This command twirls the color wheel one full turn, endlessly?
public class TwirlWheel extends CommandBase {

    private Wheeler m_wheeler;

    public TwirlWheel(Wheeler colorwheel) {
        Logger.setup("Constructing Command: TwirlWheel...");

        // Add given subsystem requirements
        m_wheeler = colorwheel;
        addRequirements(m_wheeler);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TwirlWheel...");
    }

    @Override
    public void execute() {
        m_wheeler.twirlWheel();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: TwirlWheel...");
        } else {
            Logger.ending("Ending Command: TwirlWheel...");
        }

        m_wheeler.stopWheel();
    }

}
