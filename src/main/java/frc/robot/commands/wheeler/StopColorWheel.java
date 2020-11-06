
package frc.robot.commands.wheeler;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Wheeler;

// This command stop spinning the color wheel.
public class StopColorWheel extends CommandBase {
    private Wheeler m_colorwheel;

    public StopColorWheel(Wheeler colorwheel) {
        Logger.setup("Constructing Command: StopColorWheel...");

        // Add given subsystem requirements
        m_colorwheel = colorwheel;
        addRequirements(m_colorwheel);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopColorWheel...");
    }

    @Override
    public void execute() {
        m_colorwheel.stopWheel();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: StopColorWheel...");
        } else {
            Logger.ending("Ending Command: StopColorWheel...");
        }

        m_colorwheel.stopWheel();
    }

}
