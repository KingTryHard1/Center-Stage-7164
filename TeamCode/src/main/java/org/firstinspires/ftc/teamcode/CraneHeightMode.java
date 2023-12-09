package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class CraneHeightMode extends DriveConstance {

    int lowestVal = 0;
    int highestVal = -2200;


    @Override
    public void init() {
        initRobot();
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }

    @Override
    public void loop() {
        double cranepower = gamepad1.right_stick_y;
        lift.setPower(cranepower);

        telemetry.addData("Highest Position: ", lift.getCurrentPosition());
        telemetry.update();
    }
}