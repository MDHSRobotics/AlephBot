package frc.robot.sensors.pixy;

import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.consoles.Logger;

public class TargetColor extends SubsystemBase {

    public static String detectedColor;
    private static RGB rgb;
    private static final int blockSignature = 1;

    public TargetColor() {
    }

    public String detectColor() {

        int blockCount = Camera.getPixyCamera1().getPixy().getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);
        if (blockCount <= 0) {
            Logger.error("No block count");

        }
        ArrayList<Block> blocks = Camera.getPixyCamera1().getPixy().getCCC().getBlocks();
        Block largestBlock = null;
        if (blocks == null) {
            Logger.info("No Blocks");
        }
        for (Block block : blocks) {
            if (block.getSignature() == blockSignature) {
                if (largestBlock == null) {
                    largestBlock = block;
                } else if (block.getWidth() > largestBlock.getWidth()) {
                    largestBlock = block;
                }
            }
        }
        int detectedRGB = Camera.getPixyCamera1().getPixy().getVideo().getRGB(5, 5, rgb, true);

        Logger.info(detectedRGB);

        //TODO: check values
        boolean redDetected = (detectedRGB == 1);
        boolean yellowDetected = (detectedRGB == 2);
        boolean greenDetected = (detectedRGB ==  3);
        boolean blueDetected = (detectedRGB == 4);

        if (redDetected) {
            detectedColor = "Red";
        } else if (yellowDetected) {
            detectedColor = "Yellow";
        } else if (greenDetected) {
            detectedColor = "Green";
        } else if (blueDetected) {
            detectedColor = "Blue";
        }
        return detectedColor;
    }

}