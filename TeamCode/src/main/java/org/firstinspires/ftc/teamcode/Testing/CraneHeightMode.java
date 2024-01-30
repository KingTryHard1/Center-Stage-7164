package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.DriveConstance;

@TeleOp
public class CraneHeightMode extends DriveConstance {

    int lowestVal = 0;
    int highestVal = -2200;


    @Override
    public void init() {
        initRobot();
        linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    @Override
    public void loop() {
        linearLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        telemetry.addData("Highest Position: ", linearLift.getCurrentPosition());
        telemetry.update();
    }
}