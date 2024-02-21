package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveConstance;

@TeleOp
public class planeTest extends DriveConstance {
    Switch toggle = new Switch(false, 2000);
    @Override
    public void init() {
        initRobot();
    }

    @Override
    public void loop() {

        if (toggle.returnBool())
            planePush.setPosition(1);
        else
            planePush.setPosition(0);

        toggle.changeBool(gamepad1.a, gamepad1.b);

    }
}
