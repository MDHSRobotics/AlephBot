
package frc.robot.sensors;

import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;
import edu.wpi.first.wpilibj.DriverStation;

import java.util.ArrayList;

import frc.robot.consoles.Logger;
import frc.robot.BotSensors;

public class Pixy {

    private static String detectedColor;
    private static RGB rgb;
    private static final int blockSignature = 1;

    public static int colorCounter = 0;
    public static String colorMode;

    public static String detectColor() {
        Pixy2CCC ccc = BotSensors.pixy.getCCC();
        int blockCount = ccc.getBlocks(true, Pixy2CCC.CCC_SIG_ALL, 1);
        if (blockCount <= 0) {
            Logger.problem("Pixy -> detectColor -> No block count");
        }

        ArrayList<Block> blocks = ccc.getBlocks();
        Block largestBlock = null;
        if (blocks == null) {
            Logger.info("Pixy -> detectColor -> No blocks");
        }
        for (Block block : blocks) {
            if (block.getSignature() == blockSignature) {
                if (largestBlock == null) {
                    largestBlock = block;
                }
                else if (block.getWidth() > largestBlock.getWidth()) {
                    largestBlock = block;
                }
            }
        }
        Pixy2Video video = BotSensors.pixy.getVideo();
        rgb = video.new RGB(1, 1, 1);

        byte r = rgb.getR();
        byte g = rgb.getG();
        byte b = rgb.getB();

        BotSensors.pixy.setLamp((byte) 0, (byte) 0);
        video.getRGB(5, 5, rgb, true);
        Logger.info("Pixy -> detectColor -> RGB: " + "R: " + r + ", G: " + g + ", B: " + b);

        boolean redDetected = (((r > 0) && (g > 0) && (b == 0)) || ((r == 0) && (g > 0) && (b == 0)));
        boolean yellowDetected = ((r > 0) && (g == 0) && (b == 0));
        boolean greenDetected = ((r == 0) && (g == 0) && (b >= 60));
        boolean blueDetected = ((r == 0) && (g == 0) && (b <= 45));
        boolean nothingDetected = ((r == 0) && (g == 0) && (b == 0));

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
        } else if (nothingDetected) {
            detectedColor = "White";
        }

        Logger.info("Detected Color: " + detectedColor);

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
