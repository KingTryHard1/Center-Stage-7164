package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Camera.Pipeline_Blue;
import org.firstinspires.ftc.teamcode.Camera.Pipeline_Red;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

public abstract class DriveConstance extends LinearOpMode {
    public AprilTagProcessor myAprilTagProcessor;
    public VisionPortal myVisionPortal;
    public OpenCvCamera webcam;
    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backLeft;
    public DcMotorEx backRight;

    public DcMotorEx crane;
    public DcMotorEx linearLift;
    public ServoImplEx claw;
    public ServoImplEx clawFlip;
    public ServoImplEx planeRelease;
    public DcMotorEx lift;

    public int craneHighestPosition = 4250;
    public int linearLiftHighestPosition = -5000;

    public void initRobot(){
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        crane = hardwareMap.get(DcMotorEx.class, "crane");
        linearLift = hardwareMap.get(DcMotorEx.class, "linearLift");
        claw = hardwareMap.get(ServoImplEx.class, "Claw");
        clawFlip = hardwareMap.get(ServoImplEx.class, "clawFlip");

        planeRelease = hardwareMap.get(ServoImplEx.class, "planePush");
        lift = hardwareMap.get(DcMotorEx.class, "lift");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        linearLift.setDirection(DcMotorSimple.Direction.REVERSE);
        crane.setDirection(DcMotorSimple.Direction.REVERSE);
        lift.setDirection(DcMotorSimple.Direction.REVERSE);

        crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        clawFlip.setPwmDisable();
        claw.setPwmDisable();
        crane.setMotorDisable();
        linearLift.setMotorEnable();

    }

    public void initAutoRobot(){
        crane = hardwareMap.get(DcMotorEx.class, "crane");
        linearLift = hardwareMap.get(DcMotorEx.class, "linearLift");
        lift = hardwareMap.get(DcMotorEx.class, "lift");

        linearLift.setDirection(DcMotorSimple.Direction.FORWARD);
        crane.setDirection(DcMotorSimple.Direction.REVERSE);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);

        crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void initAprilTags(){

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

    public void initOpenCV(){
        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
    }

    public void craneToPos(double power, int position) {
        crane.setTargetPosition(position);
        crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        crane.setPower(power);
    }

    public void linearLiftToPos(double power, int position) {
        linearLift.setTargetPosition(position);
        linearLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linearLift.setPower(power);
    }
}

