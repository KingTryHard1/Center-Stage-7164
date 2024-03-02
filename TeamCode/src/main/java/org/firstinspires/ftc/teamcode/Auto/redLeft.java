package org.firstinspires.ftc.teamcode.Auto;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

import org.firstinspires.ftc.teamcode.Auto.RR.MecanumDrive;
import org.firstinspires.ftc.teamcode.Camera.Pipeline_Blue;
import org.firstinspires.ftc.teamcode.DriveConstance;

public class redLeft extends DriveConstance {

    double teamElementPos;

    @Override
    public void runOpMode() throws InterruptedException {
        initOpenCV();
        Pipeline_Blue detector = new Pipeline_Blue(telemetry);
        webcam.setPipeline(detector);

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(10, -61, Math.toRadians(90)));

        Action Left = drive.actionBuilder(drive.pose)
                .setTangent(Math.toRadians(60))
                .splineToSplineHeading(new Pose2d(10, -29, Math.toRadians(180)), Math.PI / 2)
                .setTangent(Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(38, -33), Math.toRadians(0))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, -40), Math.toRadians(-90))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, -40), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,-10), Math.toRadians(0))
                .build();

        Action Middle = drive.actionBuilder(drive.pose)
                .setTangent(Math.toRadians(0))
                .lineToX(20)
                .setTangent(Math.toRadians(40))
                .splineToConstantHeading(new Vector2d(13, -33), Math.toRadians(0))
                .lineToXSplineHeading(38, Math.toRadians(180))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, -40), Math.toRadians(-90))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, -40), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,-10), Math.toRadians(0))
                .build();

        Action Right = drive.actionBuilder(drive.pose)
                .setTangent(Math.toRadians(50))
                .splineToLinearHeading(new Pose2d(13, -32, Math.toRadians(0)), Math.toRadians(90))
                .setTangent(Math.toRadians(-90))
                .splineToSplineHeading(new Pose2d(25,-48, Math.toRadians(90)), Math.toRadians(0))
                .setTangent(Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(38, -40, Math.toRadians(180)), Math.toRadians(90))
                .setTangent(Math.toRadians(45))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, -30), Math.toRadians(-90))
                .setTangent(Math.toRadians(60))
                .splineToConstantHeading(new Vector2d(-8, -9), Math.toRadians(180))
                .setTangent(Math.toRadians(20))
                .splineToConstantHeading(new Vector2d(40, -30), Math.toRadians(-90))
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(61,-10), Math.toRadians(0))
                .build();


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

            telemetry.addData("teamElementPos", teamElementPos);

            Actions.runBlocking(
                    new SequentialAction(Left)
            );
        }
    }
}
