package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@TeleOp
public class Teleop extends DriveConstance{
    @Override
    public void init() {
        //inits motors/servos
        initRobot();
        //inits camera
        initCam();

    }

    @Override
    public void loop() {

        double throttle = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        frontLeft.setPower(throttle);
        frontRight.setPower(throttle);
        backLeft.setPower(throttle);
        backRight.setPower(throttle);

        frontLeft.setPower(-strafe);
        frontRight.setPower(strafe);
        backLeft.setPower(strafe);
        backRight.setPower(-strafe);

        frontLeft.setPower(-turn);
        frontRight.setPower(turn);
        backLeft.setPower(-turn);
        backRight.setPower(turn);

        for (AprilTagDetection detection : myAprilTagProcessor.getDetections())  {

            if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }





    }
}
