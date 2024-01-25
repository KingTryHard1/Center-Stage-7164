package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveConstance;

@TeleOp
public class planeTest extends DriveConstance {
    int planePower = 0;
    @Override
    public void init() {
        initRobot();
    }

    @Override
    public void loop() {
        boolean planeOn100 = gamepad1.y;
        boolean planeOn80 = gamepad1.x;
        boolean planeOn60 = gamepad1.a;
        boolean planeOn40 = gamepad1.b;



        if (planeOn100)
            plane.setPower(.55);
        else if (planeOn80)
            plane.setPower(.50);
        else if (planeOn60)
            plane.setPower(.45);
        else if (planeOn40)
            plane.setPower(.4);
        else
            plane.setPower(0);

        if (gamepad1.left_bumper)
            planePush.setPosition(0);
        else
            planePush.setPosition(.4);


    }
}
