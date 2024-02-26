package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveConstance;

@TeleOp
public class planeTest extends DriveConstance {
    toggleBool toggle = new toggleBool(false, 2000);

    @Override
    public void runOpMode() throws InterruptedException {
        if (opModeInInit())
            initRobot();

        waitForStart();
        while (opModeIsActive()) {
            if (toggle.flipAndReturnBool(gamepad1.a, gamepad1.b))
                planeRelease.setPosition(1);
            else
                planeRelease.setPosition(0);
        }
    }
}
