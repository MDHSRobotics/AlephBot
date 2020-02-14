
package frc.robot.commands.wheeler;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Pixy;
import frc.robot.subsystems.Wheeler;

// This command spins the color wheel at a constant speed, endlessly?
public class SpinColorWheel extends CommandBase {

    private Wheeler m_wheeler;

    private int m_detectCounter;
    private boolean m_seenWrongColor = false;
    private boolean m_objectiveColorFound = false;

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
        String detectedColor = Pixy.detectColor();

                m_wheeler.spinWheel();
                if (detectedColor == Pixy.switchColor()) {
                    m_detectCounter = 0;
                } else {
                    m_detectCounter = -1;
                }

                if (m_detectCounter == 0) {
                    if (m_seenWrongColor == true) {
                        m_objectiveColorFound = true;
                    }
                } else if (m_detectCounter == -1) {
                    m_seenWrongColor = true;
                }
    }
    @Override
    public boolean isFinished() {
        boolean finished = (m_objectiveColorFound == true);
        return finished;
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
