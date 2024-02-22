package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.DriveConstance;
@TeleOp
public class CraneHeightMode extends DriveConstance {
    public void runOpMode() throws InterruptedException {
        if (opModeInInit()) {
            initRobot();

            linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            linearLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            crane.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        waitForStart();
        while (opModeIsActive()) {
            linearLift.setPower(gamepad2.right_stick_y);
            crane.setPower(gamepad2.left_stick_y);
            telemetry.addData("Highest Position LINEARLIFT: ", linearLift.getCurrentPosition());
            telemetry.addData("Highest Position CRANE: ", crane.getCurrentPosition());
            telemetry.update();
        }

    }
}