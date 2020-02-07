package frc.robot.sensors.pixy;

import frc.robot.consoles.Logger;

import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.links.Link;

public class PixyCamera {

    private final Pixy2 pixy;

    public PixyCamera(Link link) {
        pixy = Pixy2.createInstance(link);
        pixy.init();
    }

    public PixyCamera(Link link, int arg) {
        pixy = Pixy2.createInstance(link);
        int result = pixy.init(arg);
        Logger.info("Pixy init result: " + result);
    }

    public Pixy2 getPixy() {
        return pixy;
    }

}