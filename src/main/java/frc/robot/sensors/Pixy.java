
package frc.robot.sensors;

import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;
import edu.wpi.first.wpilibj.DriverStation;

import frc.robot.consoles.Logger;
import frc.robot.BotSensors;

public class Pixy {

    private static String detectedColor;
    private static RGB rgb;

    public static int colorCounter = 0;
    public static String colorMode;

    public static String detectColor() {

        Pixy2Video video = BotSensors.pixy.getVideo();
        rgb = video.new RGB(0, 0, 0);
        BotSensors.pixy.setLamp((byte) 1, (byte) 0);
        Logger.info("Pixy -> detectColor -> RGB: " + "R: " + rgb.getR() + "G: " + rgb.getG() + "B: " + rgb.getB());

        // TODO: check values
        boolean redDetected = (((rgb.getR() > 0) && (rgb.getG() > 0) && (rgb.getB() == 0)) || ((rgb.getR() == 0) && (rgb.getG() > 0) && (rgb.getB() == 0)));
        boolean yellowDetected = ((rgb.getR() > 0) && (rgb.getG() == 0) && (rgb.getB() == 0));
        boolean greenDetected = ((rgb.getR() == 0) && (rgb.getG() == 0) && (rgb.getB() >= 60));
        boolean blueDetected = ((rgb.getR() == 0) && (rgb.getG() == 0) && (rgb.getB() <= 45));

        if (redDetected) {
            detectedColor = "Red";
        }
        else if (yellowDetected) {
            detectedColor = "Yellow";
        }
        else if (greenDetected) {
            detectedColor = "Green";
        }
        else if (blueDetected) {
            detectedColor = "Blue";
        }
        return detectedColor;
    }

    public static String switchColor() {

        String gameData = DriverStation.getInstance().getGameSpecificMessage();

        if ((gameData.charAt(0)) == 'R') {
            colorCounter = 1;
        } else if ((gameData.charAt(0)) == 'Y') {
            colorCounter = 2;
        } else if ((gameData.charAt(0)) == 'G') {
            colorCounter = 3;
        } else if ((gameData.charAt(0)) == 'B') {
            colorCounter = 4;
        }

        if (colorCounter == 1) {
            colorMode = "Red";
            Logger.action("Pixy -> switchColor -> Red");
        }
        else if (colorCounter == 2) {
            colorMode = "Yellow";
            Logger.action("Pixy -> switchColor -> Yellow");
        }
        else if (colorCounter == 3) {
            colorMode = "Green";
            Logger.action("Pixy -> switchColor -> Green");
        }
        else if (colorCounter == 4) {
            colorMode = "Blue";
            Logger.action("Pixy -> switchColor -> Blue");
        }

        return colorMode;
    }

}
