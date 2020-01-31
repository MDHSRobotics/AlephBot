package frc.robot.sensors.pixy;

import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.consoles.Logger;

public class TargetColor extends SubsystemBase {

    public static String detectedColor;
    private static RGB rgb;

    public TargetColor() {
    }

    public String detectColor() {

        int detectedRGB = Camera.getPixyCamera1().getPixy().getVideo().getRGB(5, 5, rgb, true);
        Logger.info(detectedRGB);

        //TODO: check values
        boolean redDetected = (detectedRGB == 646400);
        boolean yellowDetected = (detectedRGB == 000064);
        boolean greenDetected = (detectedRGB ==  640064);
        boolean blueDetected = (detectedRGB == 640000);

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