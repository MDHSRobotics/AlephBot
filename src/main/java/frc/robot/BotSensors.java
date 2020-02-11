
package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2.LinkType;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped sensors.
public class BotSensors {

    // Attitude and Heading Reference Systems
    public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

    // Pixy
    public static final Pixy2 pixy = Pixy2.createInstance(LinkType.SPI);

    // This initialization is called in RobotManager at startup.
    public static void initializeSensors() {
        Logger.setup("Initializing BotSensors...");

        initializeGyro();
        initializePixy();
    }

    // Gyro
    private static void initializeGyro() {
        boolean gyroIsConnected = gyro.isConnected();
        if (!gyroIsConnected) {
            Logger.problem("Gyro not connected!");
        }
    }

    // Pixy
    private static void initializePixy() {
        int result = pixy.init();
        if (result == Pixy2.PIXY_RESULT_ERROR) {
            Logger.problem("Pixy2 failed to connect!");
        }
        else if (result == Pixy2.PIXY_RESULT_TIMEOUT) {
            Logger.problem("Pixy2 timed out!");
        }
        else if (result < 0) {
            Logger.problem("Pixy2 error code: " + result);
        }
    }

}
