
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ColorWheel;
import frc.robot.sensors.pixy.TargetColor;
import frc.robot.sensors.pixy.ColorMode;

// This command spins the Pickup motor
public class RotateWheel extends CommandBase {

    private ColorWheel m_colorwheel;

    public RotateWheel(ColorWheel colorwheel) {
        Logger.setup("Constructing Command: RotateWheel...");

        // Add given subsystem requirements
        m_colorwheel = colorwheel;
        addRequirements(m_colorwheel);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RotateWheel...");
    }

    @Override
    public void execute() {
        m_colorwheel.rotateWheel();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: RotateWheel...");
        } else {
            Logger.ending("Ending Command: RotateWheel...");
        }

        m_colorwheel.stopWheel();
    }

}
