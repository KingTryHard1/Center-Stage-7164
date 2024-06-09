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
public class MakeBotFair extends DriveConstance{

    ElapsedTime ReturnPlane = new ElapsedTime();
    toggleBool toggle = new toggleBool(false, 2000);
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(61,10, 0));

        if (opModeInInit()) {
            initRobot();

            lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        }

        waitForStart();
        while (opModeIsActive()){

            double linearLiftPower = gamepad1.right_stick_y;

            boolean liftUp = gamepad1.dpad_up;
            boolean liftDown = gamepad1.dpad_down;

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

            linearLift.setPower(linearLiftPower);

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
