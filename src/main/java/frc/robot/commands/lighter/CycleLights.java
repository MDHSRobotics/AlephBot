
package frc.robot.commands.lighter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Lighter;

// This command cycles through all the lights
public class CycleLights extends CommandBase {

    private Lighter m_lighter;

    // TODO: Make these constructor parameters. Use overloading for these default values.
    // To do that it must be similar to the CycleLights function
    private int NUM_SECONDS_PER_LIGHT;
    private int NUM_CYCLES;
    private int m_cycleNum;
    private int m_lightSequence;

    private Timer m_timer = new Timer();

    //This is a constructor parameter (but the Lighter is provided,
    // we have to figure out the other 4 integers)
    public CycleLights(Lighter lighter) {
        Logger.setup("Constructing Command: CycleLights...");

        // Add given subsystem requirements
        m_lighter = lighter;
        addRequirements(m_lighter);
    }

    @Override
    public void initialize() {

        Logger.action("Initializing Command: CycleLights...");

        m_cycleNum = 1;
        m_lightSequence = 0;

        m_timer.stop();
        m_timer.reset();
        m_timer.start();

        //|| Start with lights off ||\\
        /* experimenting with (m_cycleNum - 1), but would
        * this be needed if the *default switch state is m_lightSequence = 0? */
        Logger.action("CycleLights -> Turning off both lights; Cycle 0" + (m_cycleNum - 1));
        m_lighter.turnOffBoth();
    }


    @Override
    public void execute() {
        double currentTime = m_timer.get();
        if (currentTime > NUM_SECONDS_PER_LIGHT) {
            ++m_lightSequence;
            switch (m_lightSequence) {
            case 1:
                Logger.action("CycleLights -> Turning on white light; Cycle #" + m_cycleNum);
                m_lighter.turnOnWhiteOnly();
                break;
            case 2:
                Logger.action("CycleLights -> Turning on red light; Cycle #" + m_cycleNum);
                m_lighter.turnOnRedOnly();
                break;
            case 3:
                Logger.action("CycleLights -> Turning on both lights; Cycle #" + m_cycleNum);
                m_lighter.turnOnBoth();
                break;
            default:
                ++m_cycleNum;
                m_lightSequence = 0;
                if (m_cycleNum <= NUM_CYCLES) {
                    // If we're not done with all cycles, start a new cycle with both lights off
                    Logger.action("CycleLights -> Turning off both lights; Cycle #" + m_cycleNum);
                    m_lighter.turnOffBoth();
                }
            }
            m_timer.stop();
            m_timer.reset();
            m_timer.start();
        }
    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        return m_cycleNum > NUM_CYCLES;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: CycleLights...");
        } else {
            Logger.ending("Ending Command: CycleLights...");
        }

        Logger.action("CycleLights -> Turning off both lights; Cycle #" + m_cycleNum);
        m_lighter.turnOffBoth();
        m_timer.stop();
        m_timer.reset();
    }

}
