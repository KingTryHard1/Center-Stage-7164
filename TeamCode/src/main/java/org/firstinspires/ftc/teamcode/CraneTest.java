package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class CraneTest extends DriveConstance{
    @Override
    public void init() {
        initRobot();

        crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        crane.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    @Override
    public void loop() {
        double linearLiftUp = gamepad1.right_trigger;
        double linearLiftDown = -gamepad1.left_trigger;

        boolean liftUp = gamepad1.dpad_up;
        boolean liftDown = gamepad1.dpad_down;

        boolean planepower = gamepad1.b;

        double throttle = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        boolean sweeperpower = gamepad1.a;

        boolean cranepower = gamepad1.y;

        boolean outtakeClosed = gamepad1.left_bumper;
        boolean outtakeOpen = gamepad1.right_bumper;

        frontLeft.setPower(throttle);
        frontRight.setPower(throttle);
        backLeft.setPower(throttle);
        backRight.setPower(throttle);

        frontLeft.setPower(-strafe);
        frontRight.setPower(strafe);
        backLeft.setPower(strafe);
        backRight.setPower(-strafe);

        frontLeft.setPower(-turn);
        frontRight.setPower(turn);
        backLeft.setPower(-turn);
        backRight.setPower(turn);

        linearLift.setPower(linearLiftUp);
        linearLift.setPower(linearLiftDown);

        if (liftUp)
            lift.setPower(1);
        else if (liftDown)
            lift.setPower(-1);
        else
            lift.setPower(0);

        if (planepower) {
            plane.setPower(.8);
            planePush.setPosition(.4);

        }
        else {
            plane.setPower(0);
            planePush.setPosition(.8);
        }

        if (cranepower) {
            crane.setTargetPosition(craneHighestPosition);
            crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            crane.setPower(1);

        }
        else {
            crane.setTargetPosition(0);

            crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            crane.setPower(1);

        }

        if (sweeperpower) {
            sweeper.setPower(1);
        }
        else
            sweeper.setPower(0);

        if (outtakeOpen)
            outtake.setPosition(0);
        if (outtakeClosed)
            outtake.setPosition(.5);

    }
}

