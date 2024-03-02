package org.firstinspires.ftc.teamcode.Auto.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class crane {
    int Pos;
    private DcMotorEx crane;
    public crane(HardwareMap hardwareMap) {
        crane = hardwareMap.get(DcMotorEx.class, "crane");
        crane.setDirection(DcMotorSimple.Direction.REVERSE);
        crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public class craneToPos implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            crane.setTargetPosition(Pos);
            crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            crane.setPower(1);
            return false;
        }
    }
    public Action craneToPos(int toPos) {
        Pos = toPos;
        return new craneToPos();
    }
}



