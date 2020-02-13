package frc.robot.sensors;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.consoles.Logger;

public class GameData {

    public void gameData() {
        String gameData;
        gameData = DriverStation.getInstance().getGameSpecificMessage();

        if (gameData.length() > 0) {
            switch (gameData.charAt(0)) {
                case 'R' :
                    Logger.info("Color Wheel Objective: RED");
                    break;
                case 'G' :
                    Logger.info("Color Wheel Objective: GREEN");
                    break;
                case 'Y' :
                    Logger.info("Color Wheel Objective: YELLOW");
                    break;
                case 'B' :
                    Logger.info("Color Wheel Objective: BLUE");
                    break;
                default :
                    break;
            }
        }
    }
}

