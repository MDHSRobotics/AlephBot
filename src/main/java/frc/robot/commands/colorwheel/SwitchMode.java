
package frc.robot.commands.colorwheel;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.pixy.ColorMode;

// This command stops the Pickup motor
public class SwitchMode extends CommandBase {

    private ColorMode m_colorMode;

    public SwitchMode(ColorMode ColorMode) {
        Logger.setup("Constructing Command: SwitchMode...");

        // Add given subsystem requirements
        m_colorMode = ColorMode;
        addRequirements(m_colorMode);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SwitchMode...");
    }

    @Override
    public void execute() {
        m_colorMode.switchColor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: SwitchMode...");
        } else {
            Logger.ending("Ending Command: SwitchMode...");
        }
    }

}
