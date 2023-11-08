package org.firstinspires.ftc.teamcode;

public class CraneTest extends DriveConstance{
    @Override
    public void init() {
        initRobot();
    }

    @Override
    public void loop() {
        boolean liftUp = gamepad1.dpad_up;
        boolean liftDown = gamepad1.dpad_down;
        double cranepower = gamepad1.right_stick_y;

        crane.setPower(cranepower);

        if (liftUp)
            lift.setPower(.3);
        if (liftDown)
            lift.setPower(-.3);
        else
            lift.setPower(0);

    }
}
