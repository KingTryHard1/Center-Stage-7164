package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.ArrayList;
import java.util.List;

@TeleOp

public class AprilTags extends DriveConstance {

    @Override
    public void init() {
        initRobot();

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



    }
}

