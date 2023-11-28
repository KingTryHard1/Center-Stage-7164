package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class DriveTrainEncoderTest extends DriveConstance{
    @Override
    public void init() {
        initRobot();

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void loop() {
        telemetry.addData("frontLeftEncoder: ", frontLeft.getCurrentPosition());
        telemetry.addData("backLeftEncoder: ", backLeft.getCurrentPosition());
        telemetry.addData("frontRightEncoder: ", frontRight.getCurrentPosition());
        telemetry.addData("backRightEncoder: ", backRight.getCurrentPosition());

    }
}
