package org.firstinspires.ftc.teamcode.SummerTest;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class Analog extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AnalogInput AnalogServoTL = hardwareMap.get(AnalogInput.class, "Servo");
        AnalogInput AnalogServoTR = hardwareMap.get(AnalogInput.class, "Servo");
        AnalogInput AnalogServoBL = hardwareMap.get(AnalogInput.class, "Servo");
        AnalogInput AnalogServoBR = hardwareMap.get(AnalogInput.class, "Servo");
        Servo ServoTL = hardwareMap.get(Servo.class, "ServoTL");
        Servo ServoTR = hardwareMap.get(Servo.class, "ServoTR");
        Servo ServoBL = hardwareMap.get(Servo.class, "ServoBL");
        Servo ServoBR = hardwareMap.get(Servo.class, "ServoBR");



        Servo[] SwerveServoArray =
                {ServoTL, ServoTR, ServoBL, ServoBR};

        waitForStart();
        while (opModeIsActive()){


        }
    }

    public static double GetPosition(@NonNull AnalogInput Servo){
        double position = Servo.getVoltage() / 3.3 * 360;

        return position;

    }
}
