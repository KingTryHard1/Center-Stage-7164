package org.firstinspires.ftc.teamcode.SummerTest;

import android.os.Build;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.PwmControl;

import java.util.Dictionary;
import java.util.Hashtable;

public class Analog extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        AnalogInput AnalogServoTL = hardwareMap.get(AnalogInput.class, "Servo");
        //AnalogInput AnalogServoTR = hardwareMap.get(AnalogInput.class, "Servo");
        //AnalogInput AnalogServoBL = hardwareMap.get(AnalogInput.class, "Servo");
        //AnalogInput AnalogServoBR = hardwareMap.get(AnalogInput.class, "Servo");
        CRServoImplEx ServoTL = hardwareMap.get(CRServoImplEx.class, "ServoTL");
        //CRServoImplEx ServoTR = hardwareMap.get(CRServoImplEx.class, "ServoTR");
        //CRServoImplEx ServoBL = hardwareMap.get(CRServoImplEx.class, "ServoBL");
        //CRServoImplEx ServoBR = hardwareMap.get(CRServoImplEx.class, "ServoBR");

        Dictionary<String, CRServoImplEx> SwerveServos = new Hashtable<>();

        SwerveServos.put("ServoTL", ServoTL);
        //SwerveServos.put("ServoTR", ServoTR);
        //SwerveServos.put("ServoBL", ServoBL);
        //SwerveServos.put("ServoBR", ServoBR);

        for (int i = 0; SwerveServos.size()> i; i++){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                SwerveServos.elements().asIterator().next().setPwmRange(new PwmControl.PwmRange(500, 2500));
            }

        }

        waitForStart();
        while (opModeIsActive()){
            double servoPower = gamepad1.right_stick_x;

            SwerveServos.get("ServoTL").setPower(servoPower);
            telemetry.addData("Pos: ", GetPosition(AnalogServoTL));


        }
    }

    public static double GetPosition(@NonNull AnalogInput Servo){
        double position = Servo.getVoltage() / 3.3 * 360;

        return position;

    }
}