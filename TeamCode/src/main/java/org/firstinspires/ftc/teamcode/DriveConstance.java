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

import java.util.concurrent.atomic.AtomicBoolean;

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
    Servo planePush;
    DcMotorEx lift;
    CRServo sweeper;
    Servo outtake;

    int craneHighestPosition = -1650;
    int liftHighestPosition = 5000;
    double maxPlanePower = 45; //This is a percentage

    void initRobot(){
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        crane = hardwareMap.get(DcMotorEx.class, "crane");
        linearLift = hardwareMap.get(DcMotorEx.class, "linearLift");

        plane = hardwareMap.get(DcMotorEx.class, "plane");
        planePush = hardwareMap.get(Servo.class, "planePush");
        lift = hardwareMap.get(DcMotorEx.class, "lift");

        sweeper = hardwareMap.get(CRServo.class, "sweeper");
        outtake = hardwareMap.get(Servo.class, "outtake");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        plane.setDirection(DcMotorSimple.Direction.REVERSE);
        lift.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
    static ElapsedTime timeSleep = new ElapsedTime();
    boolean placeHolder = false;
    public boolean Switch(boolean gamepad) {
        if (gamepad && timeSleep.milliseconds() >= 500){
            placeHolder = !placeHolder;

        }
        return placeHolder;
    }
    boolean placeHolder2 = false;
    public boolean Switch2(boolean gamepad) {
        if (gamepad && timeSleep.milliseconds() >= 500){
            placeHolder2 = !placeHolder2;

        }
        return placeHolder2;
    }
    boolean placeHolder3 = false;
    public boolean Switch3(boolean gamepad) {
        if (gamepad && timeSleep.milliseconds() >= 500){
            placeHolder3 = !placeHolder3;

        }
        return placeHolder3;
    }
    public boolean Switch4(boolean gamepad){
            AtomicBoolean placeHolder4 = new AtomicBoolean(false);
            if (gamepad && timeSleep.milliseconds() >= 500) {
                placeHolder4.set(!placeHolder4.get());

            }

            return placeHolder4.get();
    }
    public void forward(int amount){

        frontLeft.setTargetPosition(amount);
        frontRight.setTargetPosition(amount);
        backLeft.setTargetPosition(amount);
        backRight.setTargetPosition(amount);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(-1);
        frontRight.setPower(-1);
        backLeft.setPower(-1);
        backRight.setPower(-1);

    }
}

