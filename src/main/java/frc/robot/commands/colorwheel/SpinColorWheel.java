
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ColorWheel;
import frc.robot.sensors.pixy.TargetColor;
import frc.robot.sensors.pixy.ColorMode;

// This command spins the Pickup motor
public class SpinColorWheel extends CommandBase {

    private ColorWheel m_colorwheel;
    private TargetColor m_targetColor;
    private ColorMode m_colorMode;

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
        if (m_colorMode.switchColor() != "Red") {
            while (m_targetColor.detectColor() == "Red") {
                m_colorwheel.spinWheel();
            }
        } else if (m_colorMode.switchColor() != "Yellow") {
            while (m_targetColor.detectColor() == "Yellow") {
                m_colorwheel.spinWheel();
            }
        } else if (m_colorMode.switchColor() != "Green") {
            while (m_targetColor.detectColor() == "Green") {
                m_colorwheel.spinWheel();
            }
        } else if (m_colorMode.switchColor() != "Blue") {
            while (m_targetColor.detectColor() == "Blue") {
                m_colorwheel.spinWheel();
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

        m_colorwheel.stopWheel();
    }

}
