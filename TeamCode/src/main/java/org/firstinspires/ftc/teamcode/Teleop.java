package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Teleop extends DriveConstance{
    @Override
    public void init() {
        //inits motors/servos
        initRobot();
        //inits camera
        initCam();

    }

    @Override
    public void loop() {

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







    }
}
