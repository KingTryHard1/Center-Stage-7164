package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

@TeleOp
public class Teleop extends DriveConstance{
    @Override
    public void init() {
        //inits objects
        initRobot();

        AprilTagProcessor myAprilTagProcessor;
// Create the AprilTag processor and assign it to a variable.
        myAprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();

        VisionPortal myVisionPortal;

// Create a VisionPortal, with the specified camera and AprilTag processor, and assign it to a variable.
        myVisionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Webcam"), myAprilTagProcessor);

    }

    @Override
    public void loop() {

        double throttle = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        frontLeft.setPower(throttle);
        frontRight.setPower(-throttle);
        backLeft.setPower(throttle);
        backRight.setPower(-throttle);

        frontLeft.setPower(-strafe);
        frontRight.setPower(-strafe);
        backLeft.setPower(strafe);
        backRight.setPower(strafe);

        frontLeft.setPower(-turn);
        frontRight.setPower(-turn);
        backLeft.setPower(-turn);
        backRight.setPower(-turn);







    }
}
