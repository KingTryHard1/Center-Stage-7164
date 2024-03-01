package org.firstinspires.ftc.teamcode.Auto.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class linearLift {
    private DcMotorEx linearLift;

    public linearLift(HardwareMap hardwareMap) {
        linearLift = hardwareMap.get(DcMotorEx.class, "linearLift");
        linearLift.setDirection(DcMotorSimple.Direction.REVERSE);
        linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public class CloseClaw implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            return false;
        }
    }
    public Action closeClaw() {
        return new linearLift.CloseClaw();
    }
    public class OpenClaw implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {

            return false;
        }
    }
    public Action openClaw() {
        return new linearLift.OpenClaw();
    }
}

