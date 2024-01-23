package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveConstance;

@Disabled
public class OuttakeTest extends DriveConstance {
    @Override
    public void init() {
        initRobot();
    }

    @Override
    public void loop() {
        boolean outtakeOpen = gamepad1.x;
        boolean outtakeClosed = gamepad1.y;

        if (outtakeOpen)
            outtake.setPosition(0);
        if (outtakeClosed)
            outtake.setPosition(.5);

    }
}
