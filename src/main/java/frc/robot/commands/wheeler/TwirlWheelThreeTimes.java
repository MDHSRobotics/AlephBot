
package frc.robot.commands.wheeler;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Pixy;
import frc.robot.subsystems.Wheeler;

// This command twirls the color wheel one full turn, endlessly?
public class TwirlWheelThreeTimes extends CommandBase {

	private Wheeler m_wheeler;

    private String m_initDetectedColor;
    private int m_numOfHalfTurns = 0;
    private int m_detectCounter;
    private boolean m_seenWrongColor = false;

    public TwirlWheelThreeTimes(Wheeler wheeler) {
        Logger.setup("Constructing Command: TwirlWheel...");

        // Add given subsystem requirements
        m_wheeler = wheeler;
        addRequirements(m_wheeler);
    }

	@Override
    public void initialize() {
        Logger.action("Initializing Command: TwirlWheel...");
        m_initDetectedColor = Pixy.detectColor();
    }

    @Override
    public void execute() {

       String detectedColor = Pixy.detectColor();

        m_wheeler.spinWheel();
        if (detectedColor == m_initDetectedColor) {
            m_detectCounter = 0;
        } else {
            m_detectCounter = -1;
        }

        if (m_detectCounter == 0) {
            if (m_seenWrongColor == true) {
                m_numOfHalfTurns += 1;
                m_seenWrongColor = false;
            }
        } else if (m_detectCounter == -1) {
            m_seenWrongColor = true;
        }

    }

    @Override
    public boolean isFinished() {
        boolean finished = (m_numOfHalfTurns >= 7);
        return finished;
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
