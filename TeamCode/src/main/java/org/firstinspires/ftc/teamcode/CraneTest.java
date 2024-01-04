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

        double linearLiftUp = gamepad1.left_trigger;
        double linearLiftDown = gamepad1.right_trigger;

        boolean liftUp = gamepad1.dpad_up;
        boolean liftDown = gamepad1.dpad_down;

        boolean planeOnSwitch = Switch(gamepad1.b);

        double throttle = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        boolean sweeperOnSwitch = Switch(gamepad1.a);

        //boolean craneOnSwitch = Switch3(gamepad1.y);
        double cranepower = gamepad1.right_stick_y;

        boolean outtakeClosed = gamepad1.left_bumper;
        boolean outtakeOpen = gamepad1.right_bumper;

        telemetry.addData("linearLiftUp",linearLiftUp);
        telemetry.addData("linearliftDown",linearLiftDown);
        telemetry.update();

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

        /*if (linearLiftUp>0) {
            linearLift.setDirection(DcMotorSimple.Direction.REVERSE);
            linearLift.setPower(linearLiftUp);
        } else if (linearLiftDown>0) {
            linearLift.setDirection(DcMotorSimple.Direction.FORWARD);
            linearLift.setPower(linearLiftDown);
        }

         */
        linearLift.setPower(linearLiftUp);
        linearLift.setPower(-1*linearLiftDown);

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

        if (planeOnSwitch)
            plane.setPower(1);
        else
            plane.setPower(0);

        /*if (craneOnSwitch) {
            crane.setTargetPosition(craneHighestPosition);
            crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            crane.setPower(1);

        }
        else if (!craneOnSwitch){
            crane.setTargetPosition(0);
            crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            crane.setPower(1);

        }
         */
        crane.setPower(cranepower);

        if (sweeperOnSwitch) {
            sweeper.setPower(1);
        }
        else if (!sweeperOnSwitch)
            sweeper.setPower(0);

        if (outtakeOpen)
            outtake.setPosition(0);
        if (outtakeClosed)
            outtake.setPosition(.5);

    }

}

