
package frc.robot.commands.wheeler;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Pixy;
import frc.robot.subsystems.Wheeler;

// This command spins the color wheel at a constant speed, endlessly?
public class SpinColorWheel extends CommandBase {

    private Wheeler m_wheeler;

    public SpinColorWheel(Wheeler colorwheel) {
        Logger.setup("Constructing Command: SpinColorWheel...");

        // Add given subsystem requirements
        m_wheeler = colorwheel;
        addRequirements(m_wheeler);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinColorWheel...");
    }

    @Override
    public void execute() {
        if (Pixy.switchColor() == "Red") {
            while (Pixy.detectColor() != "Red") {
                m_wheeler.spinWheel();
            }
        }
        else if (Pixy.switchColor() == "Yellow") {
            while (Pixy.detectColor()!= "Yellow") {
                m_wheeler.spinWheel();
            }
        }
        else if (Pixy.switchColor() == "Green") {
            while (Pixy.detectColor() != "Green") {
                m_wheeler.spinWheel();
            }
        }
        else if (Pixy.switchColor() == "Blue") {
            while (Pixy.detectColor() != "Blue") {
                m_wheeler.spinWheel();
            }
        }
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

        m_wheeler.stopWheel();
    }

}
