
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ColorWheel;

// This command spins the Pickup motor
public class SpinColorWheel extends CommandBase {

    private ColorWheel m_colorwheel;

    public SpinColorWheel(ColorWheel colorwheel) {
        Logger.setup("Constructing Command: SpinColorWheel...");

        // Add given subsystem requirements
        m_colorwheel = colorwheel;
        addRequirements(m_colorwheel);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinColorWheel...");
    }

    @Override
    public void execute() {
        m_colorwheel.spinWheel();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: SpinColorWheel...");
        } else {
            Logger.ending("Ending Command: SpinColorWheel...");
        }

        m_colorwheel.stopWheel();
    }

}
