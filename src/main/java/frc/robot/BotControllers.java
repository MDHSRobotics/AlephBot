
package frc.robot;

import frc.robot.oi.controllers.XboxControllerContainer;
import frc.robot.consoles.Logger;

// This class contains the robot controllers and defined ports.
public class BotControllers {

    // Controllers
    public static final XboxControllerContainer primary = new XboxControllerContainer(0);

    // Configure all the controllers
    public static void configure() {
        configurePrimary();
    }

    // Configure the "primary" controller
    public static void configurePrimary() {
        // Detect whether the primary controller has been plugged in after start-up
        if (!BotControllers.primary.configured) {
            boolean isConnected = BotControllers.primary.isConnected();
            if (!isConnected)
                return;

            // Configure button bindings
            ButtonBindings.configurePrimary();
            BotControllers.primary.configured = true;
            Logger.setup("Primary controller detected and configured");
        }
    }

}
