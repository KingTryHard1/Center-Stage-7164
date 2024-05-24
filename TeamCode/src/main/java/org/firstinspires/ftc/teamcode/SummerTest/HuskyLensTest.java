package org.firstinspires.ftc.teamcode.SummerTest;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class HuskyLensTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while (opModeIsActive()){
             HuskyLens test = hardwareMap.get(HuskyLens.class, "HuskyLens");


        }
    }
}
