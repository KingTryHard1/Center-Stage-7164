package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotUpTest extends DriveConstance{
    int UpHighPos = 0;

    public ElapsedTime UpTime = new ElapsedTime();
    @Override
    public void init() {
        initRobot();

    }

    @Override
    public void loop() {
        //Resetting runtime so it can be used to know when to use gamepad for robotUp
        resetRuntime();

        Switch(gamepad1.a);
    }

    public void Switch(boolean gamepad){
        boolean placeholder = false;

        if (gamepad)
            placeholder = true;

        if (placeholder){
            lift.setTargetPosition(UpHighPos);
            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift.setPower(1);

            if (gamepad){
                lift.setTargetPosition(0);
                lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                lift.setPower(1);

            }
        }
        else{
            lift
            .setPower(0);
            lift.setMotorDisable();
        }
    }
}
