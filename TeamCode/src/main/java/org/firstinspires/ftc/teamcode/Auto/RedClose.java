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
        crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        Pose2d startPose = new Pose2d(10, -61, Math.toRadians(90));
        drive.setPoseEstimate(startPose);
        waitForStart();
        TrajectorySequence Robot = drive.trajectorySequenceBuilder(startPose)
                .splineTo(new Vector2d(14.5,-34), Math.toRadians(90))
                .addTemporalMarker(() -> {
                    craneStopper.setPosition(0);
                    sweeper.setPower(-1);
                    craneToPos(.5,-1400);

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
                    linearLiftToPos(1, -3000);
                    outtake.setPosition(0);
                    craneStopper.setPosition(1);
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
                .lineTo(new Vector2d(61, -12))

                .build();


        drive.followTrajectorySequence(Robot);

        if (isStopRequested()){
            PoseStorage.currentPose = drive.getPoseEstimate();

        }
    }
}