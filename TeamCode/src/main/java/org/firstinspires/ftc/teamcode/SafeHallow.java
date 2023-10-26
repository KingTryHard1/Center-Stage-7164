package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class SafeHallow extends DriveConstance{
    @Override
    public void init() {
        //inits motors/servos
        initRobot();
    }

    @Override
    public void loop() {

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        double throttle = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;
        double cranepower = gamepad1.right_stick_y;
        double grab = gamepad1.left_trigger;
        double release = gamepad1.right_trigger;

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

        crane.setPower(cranepower);

        if (grab>release)
            lefts.setPower(grab);
        else if (release>grab)
            lefts.setPower(-release);
        else if (release==grab)
            lefts.setPower(0);

    }
}