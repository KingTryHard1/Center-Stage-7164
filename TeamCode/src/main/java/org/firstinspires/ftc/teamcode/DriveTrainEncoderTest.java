package org.firstinspires.ftc.teamcode;

public class DriveTrainEncoderTest extends DriveConstance{
    @Override
    public void init() {
        initRobot();

        frontLeft.setMotorDisable();
        backLeft.setMotorDisable();
        frontRight.setMotorDisable();
        backLeft.setMotorDisable();
    }

    @Override
    public void loop() {
        telemetry.addData("frontLeftEncoder: ", frontLeft.getCurrentPosition());
        telemetry.addData("backLeftEncoder: ", backLeft.getCurrentPosition());
        telemetry.addData("frontRightEncoder: ", frontRight.getCurrentPosition());
        telemetry.addData("backRightEncoder: ", backRight.getCurrentPosition());

    }
}
