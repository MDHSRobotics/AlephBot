
package frc.robot.sensors;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import io.github.pseudoresonance.pixy2api.Pixy2Video;
import io.github.pseudoresonance.pixy2api.Pixy2Video.RGB;

import frc.robot.consoles.Logger;

import java.lang.reflect.Array;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.BotSensors;

public class Pixy {
    private static final Pixy2 pixy;
    private static String detectedColor;
    private static RGB rgb;

    public static int colorCounter = 0;
    public static String colorMode;

    public static String detectColor() {



        Pixy2Video video = BotSensors.pixy.getVideo();
        rgb = video.new RGB(0, 0, 0);

        video.getRGB(5, 5, rgb, true);
        byte r = rgb.getR();
        byte g = rgb.getG();
        byte b = rgb.getB();

        BotSensors.pixy.setLamp((byte) 0, (byte) 0);
        Logger.info("Pixy -> detectColor -> RGB: " + "R: " + r + ", G: " + g + ", B: " + b);

        byte redCCC = Pixy2CCC.CCC_SIG1;
        byte greenCCC = Pixy2CCC.CCC_SIG2;
        byte yellowCCC = Pixy2CCC.CCC_SIG3;
        byte blueCCC = Pixy2CCC.CCC_SIG4;

        int redBlockCount = pixy.getCCC().getBlocks(false, redCCC, 25);
        int greenBlockCount = pixy.getCCC().getBlocks(false, greenCCC, 25);
        int yellowBlockCount = pixy.getCCC().getBlocks(false, yellowCCC, 25);
        int blueBlockCount = pixy.getCCC().getBlocks(false, blueCCC, 25);

        List<Integer> blockCountList = new ArrayList<Integer>();
        blockCountList.add(redBlockCount);
        blockCountList.add(greenBlockCount);
        blockCountList.add(yellowBlockCount);
        blockCountList.add(blueBlockCount);

        Collections.sort(blockCountList, Collections.reverseOrder());

        int detectedCCC =

        // if (redDetected) {
        //     detectedColor = "Red";
        // }
        // else if (yellowDetected) {
        //     detectedColor = "Yellow";
        // }
        // else if (greenDetected) {
        //     detectedColor = "Green";
        // }
        // else if (blueDetected) {
        //     detectedColor = "Blue";
        // } else if (nothingDetected) {
        //     detectedColor = "White";
        // }

        Logger.info("Detected Color: " + detectedColor);
        BotSensors.pixy.setLamp((byte) 0, (byte) 0);

        return detectedColor;
    }

    public static String switchColor() {

        String gameData = DriverStation.getInstance().getGameSpecificMessage();

        if ((gameData.charAt(0)) == 'R') {
            colorCounter = 1;
        } else if ((gameData.charAt(0)) == 'Y') {
            colorCounter = 2;
        } else if ((gameData.charAt(0)) == 'G') {
            colorCounter = 3;
        } else if ((gameData.charAt(0)) == 'B') {
            colorCounter = 4;
        }

        switch (colorCounter){
            case 1:
                colorCounter = 1;{
                    colorMode = "Red";
                    Logger.action("Pixy -> switchColor -> Red")
                }
            case 2:
                colorCounter = 2;{
                    colorMode = "Yellow";
                    Logger.action("Pixy -> switchColor -> Yellow")
                }
            case 3:
                colorCounter = 3;{
                    colorMode = "Green";
                    Logger.action("Pixy -> switchColor -> Green")
                }
            case 4:
                colorCounter = 4;{
                    colorMode = "Blue";
                    Logger.action("Pixy -> switchColor -> Blue")
                }
        }

        return colorMode;
    }

}

