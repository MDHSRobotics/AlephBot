
package frc.robot.sensors;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;

import frc.robot.consoles.Logger;

import frc.robot.BotSensors;

public class Pixy {

    public static int colorCounter = 0;
    public static String colorMode;

    // detectColor's problem was that it had too many functions. Solved
    // by nesting the 3 if statements per function into 1 if statement per function.

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

        // compares red values to green values (compacted from multiple if statements into a single boolean)
        if ((redBlockCount > greenBlockCount) &&
            (redBlockCount > blueBlockCount) &&
            (redBlockCount > yellowBlockCount)) {
            colorWithHighestCount = "Red";
        }

        // compares green values to red values
        if ((greenBlockCount > redBlockCount) &&
            (greenBlockCount > blueBlockCount) &&
            (greenBlockCount > yellowBlockCount)) {
            colorWithHighestCount = "Green";
        }

        // compares blue values to green values
        if ((blueBlockCount > greenBlockCount) &&
            (blueBlockCount > redBlockCount) &&
            (blueBlockCount > yellowBlockCount)) {
            colorWithHighestCount = "Blue";
        }

        // compares yellow values to green values
        if ((yellowBlockCount > greenBlockCount) &&
            (yellowBlockCount > redBlockCount) &&
            (yellowBlockCount > blueBlockCount)) {
            colorWithHighestCount = "Yellow";
        }
        // Why is this here?
        Logger.info("Red blocks: " + redBlockCount);
        Logger.info("Yellow blocks: " + yellowBlockCount);
        Logger.info("Blue Blocks: " + blueBlockCount);
        Logger.info("Green Blocks: " + greenBlockCount);

        // just to test if system.out.print is the same as Logger.info
        System.out.print("Red blocks: " + redBlockCount);

        Logger.info("Color detected: " + colorWithHighestCount);
        return colorWithHighestCount;

    }
}



