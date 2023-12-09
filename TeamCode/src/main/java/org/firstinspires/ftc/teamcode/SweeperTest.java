package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class SweeperTest extends DriveConstance{
    @Override
    public void init() {
        initRobot();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            sweeper.setPower(1);
        }
        if (gamepad1.b){
            sweeper.setPower(0);
        }

    }
}
