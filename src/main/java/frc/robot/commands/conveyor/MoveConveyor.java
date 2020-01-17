
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

// This command opens the Conveyor claw via encoder to grab the hatch, and keeps it there
public class MoveConveyor extends CommandBase {

    private Conveyor m_conveyor;

    public MoveConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: MoveConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: MoveConveyor...");
    }

    @Override
    public void execute() {
        m_conveyor.move();
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: OpenHatchClaw...");
        } else {
            Logger.ending("Ending Command: OpenHatchClaw...");
        }

        m_conveyor.stop();
    }

}
