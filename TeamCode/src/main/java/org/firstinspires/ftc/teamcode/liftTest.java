package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class liftTest extends DriveConstance{
    int UpHighPos = 0;
    @Override
    public void init() {
        initRobot();

    }

    @Override
    public void loop() {
        //Resetting runtime so it can be used to know when to use allow gamepad.a for the lift
        resetRuntime();

        if (getRuntime()>=120)
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
            lift.setPower(0);
            lift.setMotorDisable();
        }
    }
}
