package frc.robot.sensors.pixy;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.consoles.Logger;

public class ColorMode extends SubsystemBase {

    public int colorCounter = 0;
    public String colorMode;

    public ColorMode() {
    }

    public String switchColor() {
        if (colorCounter == 4) {
            colorCounter = 1;
        } else {
            colorCounter += 1;
        }

        if (colorCounter == 1) {
            colorMode = "Red";
            Logger.action("Switched Mode to Red");
        } else if (colorCounter == 2) {
            colorMode = "Yellow";
            Logger.info("Switched Mode to Yellow");
        } else if (colorCounter == 3) {
            colorMode = "Green";
            Logger.info("Switched Mode to Green");
        } else if (colorCounter == 4) {
            colorMode = "Blue";
            Logger.info("Switched Mode to Blue");
        }

        return colorMode;
    }
}