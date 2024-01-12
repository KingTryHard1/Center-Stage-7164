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
        boolean planeOn = gamepad1.y;
        boolean planeOff = gamepad1.x;

        if (planeOn)
            plane.setPower(.7);
        if (planeOff)
            plane.setPower(0);
    }
}
