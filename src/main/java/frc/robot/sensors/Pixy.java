
package frc.robot.sensors;

import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;

import java.util.ArrayList;

import frc.robot.consoles.Logger;
import frc.robot.BotSensors;

public class Pixy {

    public static String detectedColor;
    private static RGB rgb;
    private static final int blockSignature = 1;

    public static int colorCounter = 0;
    public static String colorMode;

    public static String detectColor() {
        Pixy2CCC ccc = BotSensors.pixy.getCCC();
        int blockCount = ccc.getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
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
        int detectedRGB = video.getRGB(5, 5, rgb, true);
        Logger.info("Pixy -> detectColor -> RGB: " + "R: " + rgb.getR() + "G: " + rgb.getG() + "B: " + rgb.getB());
        Logger.info("Pixy -> detectColor -> RGB: " + detectedRGB);

        // TODO: check values
        boolean redDetected = (detectedRGB == 1);
        boolean yellowDetected = (detectedRGB == 2);
        boolean greenDetected = (detectedRGB == 3);
        boolean blueDetected = (detectedRGB == 4);

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
        if (colorCounter == 4) {
            colorCounter = 1;
        } else {
            colorCounter += 1;
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
