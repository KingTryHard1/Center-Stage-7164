package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

abstract class DriveConstance extends OpMode {

    AprilTagProcessor myAprilTagProcessor;
    VisionPortal myVisionPortal;

    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;

    DcMotorEx crane;
    DcMotorEx linearLift;
    DcMotorEx plane;
    DcMotorEx lift;
    CRServo sweeper;
    Servo outtake;

    int craneHighestPosition = -2100;
    int liftHighestPosition = 7875;

    void initRobot(){
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        crane = hardwareMap.get(DcMotorEx.class, "crane");
        linearLift = hardwareMap.get(DcMotorEx.class, "linearLift");
        plane = hardwareMap.get(DcMotorEx.class, "plane");
        lift = hardwareMap.get(DcMotorEx.class, "lift");

        sweeper = hardwareMap.get(CRServo.class, "sweeper");
        outtake = hardwareMap.get(Servo.class, "outtake");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        plane.setDirection(DcMotorSimple.Direction.REVERSE);
        lift.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    void initCam(){

        myAprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .build();

        myVisionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam"))
                .addProcessor(myAprilTagProcessor)
                .setCameraResolution(new Size(640, 480))
                .setStreamFormat(VisionPortal.StreamFormat.YUY2)
                .enableLiveView(true)
                .setAutoStopLiveView(true)
                .build();

    }
    //static boolean placeHolder = false;
    static ElapsedTime timeSleep = new ElapsedTime();
    public boolean Switch(boolean gamepad, boolean startReturn){

        if (gamepad & timeSleep.milliseconds() >= 500){
            timeSleep.reset();

            startReturn = !startReturn;
        }
        return startReturn;
    }
}
