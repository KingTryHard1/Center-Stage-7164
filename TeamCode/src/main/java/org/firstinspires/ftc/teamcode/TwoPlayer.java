package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TwoPlayer extends DriveConstance{
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

        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x; // *1.1 Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        double linearLiftPower = gamepad2.left_stick_y;

        boolean liftUp = gamepad1.dpad_up;
        boolean liftDown = gamepad1.dpad_down;

        boolean planepower = gamepad1.b;
        boolean planepowerBlue = gamepad1.x;
        boolean planePushBool = gamepad1.left_bumper;

        double cranepower = -gamepad2.right_stick_y;

        boolean outtakeClosed = gamepad2.left_bumper;
        boolean outtakeOpen = gamepad2.right_bumper;

        if (gamepad2.dpad_left)
            craneStopper.setPosition(0);
        else if (gamepad2.dpad_right)
            craneStopper.setPosition(1);

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);

        telemetry.addData("linearlift", linearLift.getPower());
        telemetry.addData("Linearlift", linearLift.getCurrentPosition());
        telemetry.addData("LinearliftPower", linearLiftPower);

        if (linearLiftPower>.2)
            linearLift.setPower(1);
        else if (linearLiftPower<-.2)
            linearLift.setPower(-.7);
        else
            linearLift.setPower(0);

        /*if (gamepad2.a){

            linearLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }*/
        crane.setPower(cranepower);


        if (liftUp)
            lift.setPower(1);
        else if (liftDown)
            lift.setPower(-1);
        else
            lift.setPower(0);

        if (planePushBool)
            planePush.setPosition(0);
        else
            planePush.setPosition(.4);


        if (planepower) {
            plane.setPower(.45);

        }
        else if (planepowerBlue){
            plane.setPower(.6);
        }
        else {
        plane.setPower(0);
    }

        /*if (cranepower>0.1) {
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

         */

        if (outtakeOpen)
            outtake.setPosition(1);
        else //if (outtakeClosed)
            outtake.setPosition(0);

    }
}
