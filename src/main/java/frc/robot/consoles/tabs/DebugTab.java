
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Debug Tab
public class DebugTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;
    private ComplexWidget m_schedulerWidget;

    // Constructor
    public DebugTab() {
        ShuffleLogger.logTrivial("Constructing DebugTab...");

        m_tab = Shuffleboard.getTab("Debug");
    }

    // Create Brain Widgets
    public void preInitialize() {
        // without any objects in here this breaks
    }

    // Create all other Widgets
    public void initialize() {
        //  Command Scheduler - Not sure why this isn't working
        // Perhaps change to a log?
        CommandScheduler sched = CommandScheduler.getInstance();
        m_schedulerWidget = m_tab.add("Command Scheduler", sched);
    }

    // Configure all Widgets (Why)
    public void configure() {
        m_schedulerWidget.withPosition(0, 1);
        m_schedulerWidget.withSize(2, 1);
    }

    // This will be called in the robotPeriodic
    public void update() {
        // without any objects in here this breaks
    }

}
