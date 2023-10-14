package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import java.util.List;

@TeleOp
public class AprilTags extends DriveConstance {

    @Override
    public void init() {
        initRobot();
        initCam();

    }

    @Override
    public void loop() {
        List<AprilTagDetection> myAprilTagDetections;  // list of all detections
        int myAprilTagIdCode;                           // ID code of current detection, in for() loop

// Get a list of AprilTag detections.
        myAprilTagDetections = myAprilTagProcessor.getDetections();

// Cycle through through the list and process each AprilTag.
        for (AprilTagDetection myAprilTagDetection : myAprilTagDetections) {

            if (myAprilTagDetection.metadata != null) {  // This check for non-null Metadata is not needed for reading only ID code.
                myAprilTagIdCode = myAprilTagDetection.id;

                // Now take action based on this tag's ID code, or store info for later action.

            }
        }


        for (AprilTagDetection detection : myAprilTagProcessor.getDetections())  {

            Orientation rot = Orientation.getOrientation(detection.rawPose.R, AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

            // Original source data
            double poseX = detection.rawPose.x;
            double poseY = detection.rawPose.y;
            double poseZ = detection.rawPose.z;

            double poseAX = rot.firstAngle;
            double poseAY = rot.secondAngle;
            double poseAZ = rot.thirdAngle;

            telemetry.addData("Apriltag ID: ", detection.id);
            telemetry.addData("poseX: ", poseX);
            telemetry.addData("poseY: ", poseY);
            telemetry.addData("poseZ: ", poseZ);

            telemetry.addData("poseAX: ", poseAX);
            telemetry.addData("poseAY: ", poseAY);
            telemetry.addData("poseAZ: ", poseAZ);

        }
    }
}

