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
        boolean linearLiftUp = gamepad1.right_bumper;
        boolean linearLiftDown = gamepad1.left_bumper;

        boolean liftUp = gamepad1.dpad_up;
        boolean liftDown = gamepad1.dpad_down;

        boolean planeOn = gamepad1.y;
        boolean planeOff = gamepad1.x;

        double throttle = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

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

        if (linearLiftUp)
            linearLift.setPower(.4);
        if (linearLiftDown)
            linearLift.setPower(-.3);
        else
            linearLift.setPower(0);

        if (liftUp){
            lift.setTargetPosition(liftHighestPosition);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(1);
        }
        if (liftDown){
            lift.setTargetPosition(0);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(1);
        }

        if (planeOn)
            plane.setPower(1);
        if (planeOff)
            plane.setPower(0);

        if (gamepad1.a) {
            crane.setTargetPosition(craneHighestPosition);
            crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            crane.setPower(1);

        }

        if (gamepad1.b) {
            crane.setTargetPosition(0);
            crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            crane.setPower(1);

        }
    }
}

