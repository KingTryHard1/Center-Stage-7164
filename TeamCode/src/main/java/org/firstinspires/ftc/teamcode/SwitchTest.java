package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class SwitchTest extends DriveConstance{
    @Override
    public void init() {
        initRobot();
    }

    @Override
    public void loop() {
        if (Switch(gamepad1.a)) {
            sweeper.setPower(1);
        }
        else
            sweeper.setPower(0);
    }
}
