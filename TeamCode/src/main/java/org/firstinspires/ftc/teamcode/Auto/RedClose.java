package org.firstinspires.ftc.teamcode.Auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Auto.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.Auto.trajectorysequence.TrajectorySequence;

@Autonomous
public class RedClose extends AutonomousDriveConstance {
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(10, -61, 0);
        drive.setPoseEstimate(startPose);
        waitForStart();
        TrajectorySequence Robot = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(14.5,-34), Math.toRadians(90))
                .addTemporalMarker(() -> {
                    sweeper.setPower(1);
                    crane.setTargetPosition(400);
                    crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    crane.setPower(1);
                    sweeper.setPower(0);

                })
                .waitSeconds(1)

                .lineToSplineHeading(new Pose2d(49, -42, Math.toRadians(0)))
                .waitSeconds(1)
                .addTemporalMarker(() -> {
                    outtake.setPosition(1);
                })

                .setReversed(true)
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

                .strafeTo(new Vector2d(49,-12))
                .lineTo(new Vector2d(61, -12))

                .build();


        drive.followTrajectorySequence(Robot);
    }
}