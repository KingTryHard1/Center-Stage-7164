package org.firstinspires.ftc.teamcode.Auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.Camera.Pipeline_Blue;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;

public class BlueLong extends AutonomousDriveConstance {

    double  teamElementPos;
    double distancex = 5;

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        Pipeline_Blue detector = new Pipeline_Blue(telemetry);
        webcam.setPipeline(detector);

        Pose2d startPose = new Pose2d(-37.5,65, Math.toRadians(-90));
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(1280, 960, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });


        waitForStart();

        if (opModeIsActive()){
            switch (detector.getLocation()) {
                case LEFT:
                    teamElementPos = 1;
                    break;
                case RIGHT:
                    teamElementPos = 2;
                    break;
                case MIDDLE:
                    teamElementPos = 3;
                    break;
                case NOT_FOUND:
                    teamElementPos = 1;//should be 4
                    break;

            }

            if (teamElementPos == 2) {
                //drive.followTrajectorySequence(right);
            }
            else if (teamElementPos == 1) {
                //drive.followTrajectorySequence(left);
            }
            else if (teamElementPos == 3) {
                //drive.followTrajectorySequence(center);
            }
        }
    }
}
