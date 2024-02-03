package org.firstinspires.ftc.teamcode.Auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Auto.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.Auto.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.Camera.Pipeline_Red;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous
public class RedClose extends AutonomousDriveConstance {
    double teamElementPos;
    double distancex = 5;
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        Pipeline_Red detector = new Pipeline_Red(telemetry);

        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
        webcam.setPipeline(detector);

        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(1280, 960, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(10, -61, Math.toRadians(90));

        drive.setPoseEstimate(startPose);
        waitForStart();
        if (opModeIsActive()) {
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
                    teamElementPos = 2;//should be 4
                    break;

            }
        }

        TrajectorySequence RobotLeft = drive.trajectorySequenceBuilder(startPose)
                .splineToSplineHeading(new Pose2d(10,-32, Math.toRadians(180)), Math.toRadians(180))
                .addTemporalMarker(() -> {
                    craneStopper.setPosition(0);
                    sweeper.setPower(-.3);
                })
                .waitSeconds(1)

                .lineToSplineHeading(new Pose2d(38, -37, Math.toRadians(0)))
                .waitSeconds(1)
                .addTemporalMarker(() -> {
                    craneToPos(.5,-1700);
                    sweeper.setPower(0);
                })
                .waitSeconds(2)
                .addTemporalMarker(() -> {
                    outtake.setPosition(1);
                })
                .waitSeconds(1)
                .addTemporalMarker(()->{
                    outtake.setPosition(0);
                    //craneStopper.setPosition(1);
                    craneToPos(.7,0);

                })

                .strafeTo(new Vector2d(49,-12))
                .lineTo(new Vector2d(58, -12))

                .build();

        TrajectorySequence RobotCenter = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(14.5,-34), Math.toRadians(90))
                .addTemporalMarker(() -> {
                    craneStopper.setPosition(0);
                    sweeper.setPower(-1);
                    craneToPos(.5,-1700);

                })
                .waitSeconds(1)

                .lineToSplineHeading(new Pose2d(38, -37, Math.toRadians(0)))
                .waitSeconds(1)
                .addTemporalMarker(() -> {
                    sweeper.setPower(0);
                    outtake.setPosition(1);
                })
                .waitSeconds(1)
                .addTemporalMarker(()->{
                    outtake.setPosition(0);
                    //craneStopper.setPosition(1);
                    craneToPos(.7,0);

                })

                /*.setReversed(true)
                .splineToSplineHeading(new Pose2d(25,-11.5,Math.toRadians(180)), Math.toRadians(180))
                .lineTo(new Vector2d(-56,-11.5))
                .addDisplacementMarker(() -> {

                })
                .waitSeconds(2)
                .addTemporalMarker(()->{

                })

                .setReversed(false)
                .lineTo(new Vector2d(25,-11.5))
                .splineToConstantHeading(new Vector2d(49, -29), Math.toRadians(0))
                .addDisplacementMarker(() -> {

                })
                .waitSeconds(2)
                .addTemporalMarker(()->{

                })

                .setReversed(false)
                .splineToConstantHeading(new Vector2d(25,-11.5), Math.toRadians(180))
                .lineTo(new Vector2d(-56,-11.5))
                .addDisplacementMarker(() -> {

                })
                .waitSeconds(2)
                .addTemporalMarker(()->{

                })

                .setReversed(false)
                .lineTo(new Vector2d(25,-11.5))
                .splineToConstantHeading(new Vector2d(49, -29), Math.toRadians(0))
                .addDisplacementMarker(() -> {

                })
                .waitSeconds(2)
                .addTemporalMarker(()->{

                })

                 */

                .strafeTo(new Vector2d(38,-12))
                .lineTo(new Vector2d(58, -12))

                .build();

        TrajectorySequence RobotRight = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(13.5,-27), Math.toRadians(0))
                .waitSeconds(1)
                .addTemporalMarker(() -> {
                    craneStopper.setPosition(0);
                    sweeper.setPower(-1);
                    craneToPos(.5,-1700);
                })

                .lineToSplineHeading(new Pose2d(10, -47,Math.toRadians(0)))
                .setReversed(false)
                .splineToConstantHeading(new Vector2d(38, -37), Math.toRadians(0))
                .waitSeconds(1)
                .addTemporalMarker(() -> {
                    sweeper.setPower(0);
                    outtake.setPosition(1);
                })
                .waitSeconds(1)
                .addTemporalMarker(()->{
                    outtake.setPosition(0);
                    //craneStopper.setPosition(1);
                    craneToPos(.7,0);

                })

                .strafeTo(new Vector2d(49,-12))
                .lineTo(new Vector2d(58, -12))

                .build();
        if (opModeIsActive()) {
            if (teamElementPos == 2) {
                drive.followTrajectorySequence(RobotRight);
            } else if (teamElementPos == 1) {
                drive.followTrajectorySequence(RobotLeft);
            } else if (teamElementPos == 3) {
                drive.followTrajectorySequence(RobotCenter);
            }
        }
    }
}