package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class CraneHeightMode extends DriveConstance{

    @Override
    public void init() {
        telemetry.clearAll();
        crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }
    @Override
    public void loop() {
        int lowestVal = 0;
        int highestVal;

        int cranePosition = crane.getCurrentPosition();
        double cranepower = gamepad1.left_stick_y;

        telemetry.addLine("Go to lowest position than hit A");
        do{
            telemetry.update();
        }
        while (!gamepad1.a);
        telemetry.clearAll();

        telemetry.addLine("Go to highest position than hit A");

        do{
            telemetry.update();
        }
        while (!gamepad1.a);
        telemetry.clearAll();

        highestVal = crane.getCurrentPosition();

        telemetry.addLine("Go to lowest position than hit A");
        do{
            telemetry.update();
        }
        while (!gamepad1.a);
        telemetry.clearAll();

        crane.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        crane.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Lowest Position: ", lowestVal);
        telemetry.addData("Highest Position: ", highestVal);

        if (lowestVal <= cranePosition && cranePosition <= highestVal)
            crane.setPower(cranepower);
        else
            crane.setPower(0);

    }
}
