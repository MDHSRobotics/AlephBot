
package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.sensors.pixy.Camera;
import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped sensors.
public class BotSensors {

    // Attitude and Heading Reference Systems
    public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

    // This initialization is called in RobotManager at startup.
    public static void initializeSensors() {
        Logger.setup("Initializing BotSensors...");

        initializeGyro();
        Camera.setup();
    }

    // Gyro
    private static void initializeGyro() {
        boolean gyroIsConnected = gyro.isConnected();
        if (!gyroIsConnected) {
            Logger.problem("Gyro not connected!");
        }
    }

}
