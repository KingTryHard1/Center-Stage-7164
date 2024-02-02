package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Auto.AutonomousDriveConstance;
import org.firstinspires.ftc.teamcode.Auto.PoseStorage;
import org.firstinspires.ftc.teamcode.Auto.drive.SampleMecanumDrive;

@TeleOp
public class RRTeleopTest extends AutonomousDriveConstance {
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.setPoseEstimate(PoseStorage.currentPose);

        init();

        crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        crane.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();
        while (opModeIsActive()){

            double linearLiftPower = gamepad2.left_stick_y;

            boolean liftUp = gamepad1.dpad_up;
            boolean liftDown = gamepad1.dpad_down;

            boolean planepower = gamepad1.b;

            boolean sweeperIn = gamepad2.a;
            boolean sweeperOut = gamepad2.b;

            double cranepower = -gamepad2.right_stick_y;

            boolean outtakeClosed = gamepad2.left_bumper;
            boolean outtakeOpen = gamepad2.right_bumper;

            drive.update();

            Pose2d myPose = drive.getPoseEstimate();
            telemetry.addData("x", myPose.getX());
            telemetry.addData("y", myPose.getY());
            telemetry.addData("heading", myPose.getHeading());

            linearLift.setPower(linearLiftPower);

            if (liftUp)
                lift.setPower(1);
            else if (liftDown)
                lift.setPower(-1);
            else
                lift.setPower(0);

            if (planepower) {
                plane.setPower(.9);
                planePush.setPosition(0);

            }
            else {
                plane.setPower(0);
                planePush.setPosition(.4);
            }

            if (cranepower>0.1) {
                crane.setTargetPosition(craneHighestPosition);
                crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                crane.setPower(cranepower);

            }
            else if (cranepower<-0.1) {
                crane.setTargetPosition(0);

                crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                crane.setPower(cranepower);

            }
            else
                crane.setPower(0);

            if (sweeperIn)
                sweeper.setPower(1);

            else if (sweeperOut)
                sweeper.setPower(-1);
            else
                sweeper.setPower(0);

            if (outtakeOpen)
                outtake.setPosition(1);
            else //if (outtakeClosed)
                outtake.setPosition(0);
        }
    }
}
