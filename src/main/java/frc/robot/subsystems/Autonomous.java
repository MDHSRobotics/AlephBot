package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxDiffWheelFrontLeft;
import static frc.robot.subsystems.Devices.talonSrxDiffWheelFrontRight;
import static frc.robot.subsystems.Devices.talonSrxDiffWheelRearLeft;
import static frc.robot.subsystems.Devices.talonSrxDiffWheelRearRight;

// Lighter subsystem, for turning lights on and off.
public class Autonomous extends SubsystemBase {

    public Autonomous() {
        Logger.setup("Constructing Subsystem: Autonomous...");
    }

    public void moveForwardAuto() {
        talonSrxDiffWheelFrontLeft.set(0.5);
        talonSrxDiffWheelFrontRight.set(0.5);
        talonSrxDiffWheelRearLeft.set(0.5);
        talonSrxDiffWheelRearRight.set(0.5);

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

}