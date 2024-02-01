package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Auto.AutonomousDriveConstance;
@TeleOp
public class CraneHeightMode extends AutonomousDriveConstance {

    int lowestVal = 0;
    int highestVal = -2200;


    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();
        while (opModeIsActive()) {
            linearLiftToPos(1, -3000);

            telemetry.addData("Highest Position: ", linearLift.getCurrentPosition());
            telemetry.update();
        }

    }
}