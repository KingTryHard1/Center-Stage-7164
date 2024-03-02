package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Auto.RR.Drawing;
import org.firstinspires.ftc.teamcode.Auto.RR.MecanumDrive;
import org.firstinspires.ftc.teamcode.Testing.toggleBool;

@TeleOp
public class TwoPlayer extends DriveConstance {

     ElapsedTime ReturnPlane = new ElapsedTime();
     toggleBool toggle = new toggleBool(false, 2000);

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(61,10, 0));

        if (opModeInInit()) {
            initRobot();

            crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            crane.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            linearLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        }

        waitForStart();
        while (opModeIsActive()){

            double linearLiftPower = gamepad2.left_stick_y;

            boolean liftUp = gamepad1.dpad_up;
            boolean liftDown = gamepad1.dpad_down;

            double cranepower = -gamepad2.right_stick_y;

            boolean outtakeClose = gamepad2.left_bumper;
            boolean outtakeOpen = gamepad2.right_bumper;
            boolean clawUp = gamepad2.dpad_up;
            boolean clawDown = gamepad2.dpad_down;

            drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x
                    ),
                    -gamepad1.right_stick_x
            ));

            drive.updatePoseEstimate();

            TelemetryPacket packet = new TelemetryPacket();
            packet.fieldOverlay().setStroke("#3F51B5");
            Drawing.drawRobot(packet.fieldOverlay(), drive.pose);
            FtcDashboard.getInstance().sendTelemetryPacket(packet);

            telemetry.addData("x", drive.pose.position.x);
            telemetry.addData("y", drive.pose.position.y);
            telemetry.addData("heading (deg)", Math.toDegrees(drive.pose.heading.toDouble()));

            if (outtakeClose)
                claw.setPosition(0.05);
            else if (outtakeOpen)
                claw.setPosition(.5);

            telemetry.addData("outtakeClose:", outtakeClose);
            telemetry.addData("outtakeOpen:", outtakeOpen);

            /*if (clawUp)
                clawFlip.setPosition(1);
            if (clawDown)
                clawFlip.setPosition(0);

             */

            telemetry.addData("linearLiftPower", linearLift.getPower());
            telemetry.addData("LinearLiftPos", linearLift.getCurrentPosition());
            telemetry.addData("LinearLiftPower", linearLiftPower);

            if (linearLift.getCurrentPosition()<linearLiftHighestPosition/1.7)
                clawFlip.setPosition((double) linearLift.getCurrentPosition() / linearLiftHighestPosition);
            else
                clawFlip.setPosition(0);
            /*if (clawUp)
                clawFlip.setPosition(1);
            if (clawDown)
                clawFlip.setPosition(0);*/

            linearLift.setPower(linearLiftPower);

            if (cranepower>0.1) {
                crane.setTargetPosition(craneHighestPosition);
                crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                crane.setPower(cranepower);
            }else if (cranepower<-0.1){
                crane.setTargetPosition(0);
                crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                crane.setPower(cranepower);
            }else
                crane.setPower(0);

            if (liftUp)
                lift.setPower(1);
            else if (liftDown)
                lift.setPower(-1);
            else
                lift.setPower(0);

            if (!toggle.flipAndReturnBool(gamepad1.b)) {
                planeRelease.setPosition(0);
                ReturnPlane.reset();
            }
            else {
                planeRelease.setPosition(1);
            }


            if (toggle.returnBool())
                if (ReturnPlane.seconds()>=3) {
                    toggle.flipBool();
                    ReturnPlane.reset();
                }

            telemetry.addData("Time:", ReturnPlane.seconds());
            telemetry.update();



        }
    }
}
