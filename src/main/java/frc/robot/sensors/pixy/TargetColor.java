package frc.robot.sensors.pixy;

import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.consoles.Logger;

public class TargetColor extends SubsystemBase {

    public static String detectedColor;
    private static RGB rgb;

    public TargetColor() {
    }

    public String detectColor() {

        PixyCamera pc = Camera.getPixyCamera1();
        Pixy2 p2 = pc.getPixy();
        Logger.info("fps: " + p2.getFPS());
        Pixy2Video pv = p2.getVideo();
        int detectedRGB = pv.getRGB(5, 5, rgb, false);
        Logger.info("rgb: " + detectedRGB);
        p2.getCCC().getBlocks(false, Pixy2CCC.CCC_SIG1, 25);

        //TODO: check values
        boolean redDetected = (detectedRGB == 4);
        boolean yellowDetected = (detectedRGB == 1);
        boolean greenDetected = (detectedRGB ==  2);
        boolean blueDetected = (detectedRGB == 6);

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