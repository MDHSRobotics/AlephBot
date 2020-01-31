package frc.robot.sensors.pixy;

import frc.robot.consoles.Logger;

public class ColorMode {

    public int colorCounter = 1;
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
            Logger.action("Switched Mode to Read");
        } else if (colorCounter == 2) {
            colorMode = "Yellow";
            Logger.info("Switched Mode to Yellow");
        } else if (colorCounter == 3) {
            colorMode = "green";
            Logger.info("Green Mode");
        } else if (colorCounter == 4) {
            colorMode = "Blue";
            Logger.info("Blue Mode");
        }

        return colorMode;
    }
}