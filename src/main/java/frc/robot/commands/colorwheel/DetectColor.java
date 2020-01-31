
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;
import frc.robot.sensors.pixy.TargetColor;

// This detects the color
public class DetectColor extends CommandBase {

    private TargetColor m_targetColor;

    public DetectColor(TargetColor targetColor) {
        Logger.setup("Constructing Command: DetectColor...");

        // Add given subsystem requirements
        m_targetColor = targetColor;
        addRequirements(m_targetColor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DetectColor...");
    }

    @Override
    public void execute() {
        m_targetColor.detectColor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: DetectColor...");
        } else {
            Logger.ending("Ending Command: DetectColor...");
        }

    }

}
