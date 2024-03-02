package org.firstinspires.ftc.teamcode.Auto.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class linearLift {
    int Pos;
    private DcMotorEx linearLift;

    public linearLift(HardwareMap hardwareMap) {
        linearLift = hardwareMap.get(DcMotorEx.class, "linearLift");
        linearLift.setDirection(DcMotorSimple.Direction.REVERSE);
        linearLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public class linearLiftToPos implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            linearLift.setTargetPosition(Pos);
            linearLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            linearLift.setPower(1);
            return false;
        }
    }
    public Action linearLiftToPos(int toPos) {
        Pos = toPos;
        return new linearLift.linearLiftToPos();
    }
}

