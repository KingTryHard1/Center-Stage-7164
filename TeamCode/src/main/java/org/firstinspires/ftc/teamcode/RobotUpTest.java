package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotUpTest extends DriveConstance{
    int UpHighPos = 0;

    public ElapsedTime UpTime = new ElapsedTime();
    @Override
    public void init() {

    }

    @Override
    public void loop() {

        if (gamepad1.a) {
            UpTime.reset();
            do {
                robotUP.setTargetPosition(UpHighPos);
                robotUP.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robotUP.setPower(1);

            }
            while (UpTime.seconds() <= 2);
        }
        if (gamepad1.a) {
            do {
                robotUP.setTargetPosition(0);
                robotUP.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                robotUP.setPower(1);

            }
            while (true);

        }
    }
}
