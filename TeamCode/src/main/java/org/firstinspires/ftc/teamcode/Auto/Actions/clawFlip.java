package org.firstinspires.ftc.teamcode.Auto.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class clawFlip {
    private Servo clawflip;

    public clawFlip(HardwareMap hardwareMap) {
        clawflip = hardwareMap.get(Servo.class, "clawFlip");
    }

    public class ClawFlipForward implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            clawflip.setPosition(0);
            return false;
        }
    }
    public Action clawFlipForward() {
        return new ClawFlipForward();
    }
    public class ClawFlipBack implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            clawflip.setPosition(.7);
            return false;
        }
    }
    public Action clawFlipBack() {
        return new ClawFlipBack();
    }
}