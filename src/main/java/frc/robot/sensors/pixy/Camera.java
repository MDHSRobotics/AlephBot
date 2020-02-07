
package frc.robot.sensors.pixy;

import io.github.pseudoresonance.pixy2api.links.SPILink;

public class Camera {

    private static PixyCamera pixy1 = null;

    public static void setup() {
        SPILink spi = new SPILink();
        pixy1 = new PixyCamera(spi, 0);
    }

    public static PixyCamera getPixyCamera1() {
        return pixy1;
    }

}
