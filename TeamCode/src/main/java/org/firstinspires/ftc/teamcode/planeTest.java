package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp
public class planeTest extends DriveConstance{
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
            plane.setPower(1);
        else if (planeOn80)
            plane.setPower(.8);
        else if (planeOn60)
            plane.setPower(.6);
        else if (planeOn40)
            plane.setPower(.4);
        else
            plane.setPower(0);

    }
}
