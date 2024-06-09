package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Testing.toggleBool;

public class MakerBotFair extends DriveConstance {

    ElapsedTime ReturnPlane = new ElapsedTime();
    toggleBool toggle = new toggleBool(false, 2000);

    @Override
    public void runOpMode() throws InterruptedException {

        if (opModeInInit()) {
            initRobot();

            crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            crane.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            linearLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            clawFlip.setDirection(Servo.Direction.FORWARD);

        }

        waitForStart();
        while (opModeIsActive()) {

            boolean liftUp = gamepad1.dpad_up;
            boolean liftDown = gamepad1.dpad_down;

            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeft.setPower(frontLeftPower);
            frontRight.setPower(frontRightPower);
            backLeft.setPower(backLeftPower);
            backRight.setPower(backRightPower);

            if (liftUp)
                lift.setPower(1);
            else if (liftDown)
                lift.setPower(-1);
            else
                lift.setPower(0);

            if (!toggle.flipAndReturnBool(gamepad1.b)) {
                planeRelease.setPosition(0);
                ReturnPlane.reset();
            } else {
                planeRelease.setPosition(1);
            }


            if (toggle.returnBool())
                if (ReturnPlane.seconds() >= 3) {
                    toggle.flipBool();
                    ReturnPlane.reset();
                }

            telemetry.addData("Time:", ReturnPlane.seconds());
            telemetry.update();

        }
    }
}


