package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveConstance;

@Disabled
public class SweeperTest extends DriveConstance {
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
