
package frc.robot.commands.wheeler;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Pixy;
import frc.robot.subsystems.Wheeler;

// This command twirls the color wheel one full turn, endlessly?
public class TwirlWheelThreeTimes extends CommandBase {

	private Wheeler m_wheeler;

    private String m_initDetectedColor;
    private int m_numOfHalfTurns;
    private int m_detectCounter;
    private boolean m_seenWrongColor;

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
        m_numOfHalfTurns = 0;
        m_seenWrongColor = false;
        Logger.info("Initial Detected Color: " + m_initDetectedColor);

    }

    @Override
    public void execute() {

       String detectedColor = Pixy.detectColor();

       if (m_initDetectedColor == "White") {
            m_numOfHalfTurns = 7;
       } else {

        m_wheeler.spinWheel();
        if (detectedColor == m_initDetectedColor) {
            m_detectCounter = 0;
        } else if (detectedColor == "White") {
            m_detectCounter = 1;
        } else if (detectedColor != m_initDetectedColor) {
            m_detectCounter = -1;
        }

        if (m_detectCounter == 0) {
            if (m_seenWrongColor == true) {
                m_numOfHalfTurns += 1;
                m_seenWrongColor = false;
                Logger.info("TURNS: " + m_numOfHalfTurns);
            }
        } else if (m_detectCounter == -1) {
            m_seenWrongColor = true;

        }
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
