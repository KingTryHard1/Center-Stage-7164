package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class MotorTest extends OpMode {
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
