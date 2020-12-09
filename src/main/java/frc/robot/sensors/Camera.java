package frc.robot.sensors;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;

public class Camera extends TimedRobot {

    public void robotInit() {
        new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(640, 480);

            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);

            Mat source = new Mat();
            Mat output = new Mat();

            while (!Thread.interrupted()) {
                if (cvSink.grabFrame(source) == 0) {
                    continue;
                }
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();
    }
}