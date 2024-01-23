package org.firstinspires.ftc.teamcode.Camera;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Rect;

public class Pipeline_Blue extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();

    public enum Location {
        LEFT,
        MIDDLE,
        RIGHT,
        NOT_FOUND
    }
    public Location location = Location.NOT_FOUND;

    /*static final Rect LEFT_ROI = new Rect(
            new Point(10, 330),
            new Point(300, 830));*/

    static final Rect MID_ROI = new Rect(
            new Point(200, 330),
            new Point(650, 450));

    static final Rect RIGHT_ROI = new Rect(
            new Point(850, 330),
            new Point(1240,450));

    static double percentThreshold = 0.12;

    public Pipeline_Blue(Telemetry t){
        telemetry = t;
    }

    @Override
    public Mat processFrame(Mat input){
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);

        // Yellowish
        Scalar yellowLowHSV = new Scalar(23,70,70);
        Scalar yellowHighHSV = new Scalar(32, 255, 255);

        // Orangish
        Scalar orangeLowHSV = new Scalar(0, 59, 107);
        Scalar orangeHighHSV = new Scalar(71, 183, 255);

        //green
        Scalar greenLowHSV = new Scalar(40,40,40);
        Scalar greenHighHSV = new Scalar(70,255,255);

        //red
        Scalar redHighHSV = new Scalar(10,255,255);
        Scalar redLowHSV = new Scalar(0,50,50);

        //blue
        Scalar blueLowHSV = new Scalar(110,50,50);
        Scalar blueHighHSV = new Scalar(130,255,255);

        Core.inRange(mat, blueLowHSV, blueHighHSV, mat);

        //Mat left = mat.submat(LEFT_ROI);
        Mat mid = mat.submat(MID_ROI);
        Mat right = mat.submat(RIGHT_ROI);

        //double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 100;
        double midValue = Core.sumElems(mid).val[0] / MID_ROI.area() / 100;
        double rightValue = Core.sumElems(right).val[0] / RIGHT_ROI.area() / 100;

        mid.release();

        telemetry.addData("raw Mid value", (int) Core.sumElems(mid).val[0]);
        telemetry.addData("Mid percentage", Math.round(midValue * 100) + "%");
        telemetry.addData("Right percentage", Math.round(rightValue * 100) + "%");

        //boolean tseLeft = leftValue > percentThreshold;
        boolean tseMid = midValue > percentThreshold;
        boolean tseRight = rightValue > percentThreshold;

        /*if (tseLeft){
            location = Location.LEFT;
            telemetry.addData("Location", "Left");
        } else*/ if (tseMid){
            location = Location.MIDDLE;
            telemetry.addData("Location", "Middle");
        }else if (tseRight) {
            location = Location.RIGHT;
            telemetry.addData("Location", "Right");
        }else{
            location = Location.NOT_FOUND;
            telemetry.addData("Location", "not found");
        }
        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar tseColor = new Scalar(255,0,0);

        // Imgproc.rectangle(mat, LEFT_ROI, tseColor);
        Imgproc.rectangle(mat, MID_ROI, tseColor);
        Imgproc.rectangle(mat, RIGHT_ROI, tseColor);
        return mat;
    }
    public Location getLocation() {
        return location;
    }
}
