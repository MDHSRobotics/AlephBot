
package frc.robot.commands.wheeler;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Pixy;
import frc.robot.subsystems.Wheeler;

// This command twirls the color wheel one full turn, endlessly?
public class TwirlWheelThreeTimes extends CommandBase {

	private Wheeler m_wheeler;

    static String initDetectedColor;
    private int colorCounter = 0;
    private int detectCounter;

    public TwirlWheelThreeTimes(Wheeler colorwheel) {
        Logger.setup("Constructing Command: TwirlWheel...");

        // Add given subsystem requirements
        m_wheeler = colorwheel;
        addRequirements(m_wheeler);
    }

	@Override
    public void initialize() {
        Logger.action("Initializing Command: TwirlWheel...");
        initDetectedColor = Pixy.detectColor();
    }

    @Override
    public void execute() {

       String detectedColor = Pixy.detectColor();

        m_wheeler.spinWheel();
        if (detectedColor == initDetectedColor) {
            detectCounter = 0;
        } else {
            detectCounter = 1;
        }

        switch (detectCounter) {
	    case 0 :
                colorCounter += 1;
                if (colorCounter == 7) {
                    m_wheeler.stopWheel();
                }
                break;
            default:
                break;
        }

    }





    @Override
    public boolean isFinished() {
        boolean finished = (colorCounter >= 7);
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
