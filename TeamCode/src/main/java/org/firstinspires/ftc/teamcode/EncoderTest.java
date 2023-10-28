package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class EncoderTest extends OpMode {
    DcMotorEx motor;
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotorEx.class, "crane");

    }
    @Override
    public void loop() {
        double power = gamepad1.right_stick_y;

        motor.setPower(power);

    }
}
