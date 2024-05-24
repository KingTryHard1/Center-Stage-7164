package org.firstinspires.ftc.teamcode.SummerTest;

import androidx.annotation.NonNull;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.PwmControl;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;


public class Analog extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AnalogInput AnalogServoTL = hardwareMap.get(AnalogInput.class, "Servo");
        AnalogInput AnalogServoTR = hardwareMap.get(AnalogInput.class, "Servo");
        AnalogInput AnalogServoBL = hardwareMap.get(AnalogInput.class, "Servo");
        AnalogInput AnalogServoBR = hardwareMap.get(AnalogInput.class, "Servo");
        ServoImplEx ServoTL = hardwareMap.get(ServoImplEx.class, "ServoTL");
        ServoImplEx ServoTR = hardwareMap.get(ServoImplEx.class, "ServoTR");
        ServoImplEx ServoBL = hardwareMap.get(ServoImplEx.class, "ServoBL");
        ServoImplEx ServoBR = hardwareMap.get(ServoImplEx.class, "ServoBR");

        CRServoImplEx Test = hardwareMap.get(CRServoImplEx.class, "ServoBR");

        ServoImplEx[] SwerveServoArray =
                {ServoTL, ServoTR, ServoBL, ServoBR};

        for (int i = 0; SwerveServoArray.length >= i; i++){
            SwerveServoArray[i].setPwmRange(new PwmControl.PwmRange(500, 2500));
        }

        waitForStart();
        while (opModeIsActive()){


        }
    }

    public static double GetPosition(@NonNull AnalogInput Servo){
        double position = Servo.getVoltage() / 3.3 * 360;

        return position;

    }

}
