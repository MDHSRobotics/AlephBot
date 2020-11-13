
package frc.robot.sensors;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;

import frc.robot.consoles.Logger;

import frc.robot.BotSensors;

public class Pixy {

    public static int colorCounter = 0;
    public static String colorMode;

    //TODO: figure out why the hell this wont work
    public static String detectColor() {

        byte redCCC = Pixy2CCC.CCC_SIG1;
        byte greenCCC = Pixy2CCC.CCC_SIG2;
        byte yellowCCC = Pixy2CCC.CCC_SIG3;
        byte blueCCC = Pixy2CCC.CCC_SIG4;

        int redBlockCount = BotSensors.pixy.getCCC().getBlocks(false, redCCC, 25);
        int greenBlockCount = BotSensors.pixy.getCCC().getBlocks(false, greenCCC, 25);
        int yellowBlockCount = BotSensors.pixy.getCCC().getBlocks(false, yellowCCC, 25);
        int blueBlockCount = BotSensors.pixy.getCCC().getBlocks(false, blueCCC, 25);

        String colorWithHighestCount = "None";

        // compares red values to green values
        if (redBlockCount > greenBlockCount) {
            if (redBlockCount > blueBlockCount) {
                if (redBlockCount > yellowBlockCount) {
                    colorWithHighestCount = "Red";
                }
            }
        }

        // compares green values to red values
        if (greenBlockCount > redBlockCount) {
            if (greenBlockCount > blueBlockCount) {
                if (greenBlockCount > yellowBlockCount) {
                    colorWithHighestCount = "Green";
                }
            }
        }

        // compares blue values to green values
        if (blueBlockCount > greenBlockCount) {
            if (blueBlockCount > redBlockCount) {
                if (blueBlockCount > yellowBlockCount) {
                    colorWithHighestCount = "Blue";
                }
            }
        }

        // compares yellow values to green values
        if (yellowBlockCount > greenBlockCount) {
            if (yellowBlockCount > redBlockCount) {
                if (yellowBlockCount > blueBlockCount) {
                    colorWithHighestCount = "Yellow";
                }
            }
        }
        Logger.info("Red blocks: " + redBlockCount);
        Logger.info("Yellow blocks: " + yellowBlockCount);

        Logger.info("Color detected: " + colorWithHighestCount);
        return colorWithHighestCount;

    }
}



