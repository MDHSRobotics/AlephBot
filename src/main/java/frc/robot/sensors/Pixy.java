
package frc.robot.sensors;

import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;

import frc.robot.consoles.Logger;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.BotSensors;

public class Pixy {

    private static String detectedColor;
    private static RGB rgb;

    public static int colorCounter = 0;
    public static String colorMode;

    public static String detectColor() {

        Pixy2Video video = BotSensors.pixy.getVideo();
        rgb = video.new RGB(0, 0, 0);

        video.getRGB(5, 5, rgb, true);
        byte r = rgb.getR();
        byte g = rgb.getG();
        byte b = rgb.getB();

        BotSensors.pixy.setLamp((byte) 0, (byte) 0);
        Logger.info("Pixy -> detectColor -> RGB: " + "R: " + r + ", G: " + g + ", B: " + b);

        boolean redDetected = (((r > 0) && (g > 0) && (b == 0)) || ((r == 0) && (g > 0) && (b == 0)));
        boolean yellowDetected = ((r > 0) && (g == 0) && (b == 0));
        boolean greenDetected = ((r == 0) && (g == 0) && (b >= 48));
        boolean blueDetected = ((r == 0) && (g == 0) && (b <= 47));
        boolean nothingDetected = ((r == 0) && (g == 0) && (b == 0));

        if (redDetected) {
            detectedColor = "Red";
            BotSensors.pixy.setLamp((byte) 1, (byte) 1);

        }
        else if (yellowDetected) {
            detectedColor = "Yellow";
            BotSensors.pixy.setLamp((byte) 1, (byte) 1);
        }
        else if (greenDetected) {
            detectedColor = "Green";
        }
        else if (blueDetected) {
            detectedColor = "Blue";
        } else if (nothingDetected) {
            detectedColor = "White";
        }

        Logger.info("Detected Color: " + detectedColor);
        BotSensors.pixy.setLamp((byte) 0, (byte) 0);

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

