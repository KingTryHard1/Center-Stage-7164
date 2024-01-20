package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp
public class planeTest extends DriveConstance{
    int planePower = 0;
    @Override
    public void init() {
        initRobot();
    }

    @Override
    public void loop() {
        boolean planePowerPlus = gamepad1.y;
        boolean planePowerSub = gamepad1.x;
        boolean planeOn = gamepad1.a;
        boolean planeOff = gamepad1.b;

        telemetry.addData("Plane Power", planePower);
        if (planePowerPlus){
            if (planePower < 10){
                planePower++;
            }
        }
        if (planePowerSub) {
            if (planePower < 10) {
                planePower--;
            }
        }

        if (planeOn) {
            plane.setPower(planePower / 100);
            planePush.setPosition(.4);
        }else {
            plane.setPower(0);
            planePush.setPosition(0);
        }


    }
}
