package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.consoles.Logger;
import frc.robot.Constants.EncoderConstants;
import frc.robot.Constants.TalonConstants;
import frc.robot.EncoderUtils;
import frc.robot.SubsystemDevices;

// Pickup subsystem, for grabbing and releasing balls
public class Pickup extends SubsystemBase {

    private final boolean pickupState = false; //false = off; true = on

    public Pickup() {
        Logger.setup("Constructing Subsystem: Pickup...");
        if (pickupState) {
            talonSrxPickup.set(0.5);
            boolean pickupState = true;
        } else {
            talonSrxPickup.stop();
            boolean pickupState = false;
        }

    }

}


