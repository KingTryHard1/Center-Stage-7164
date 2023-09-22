package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

class test extends OpMode {


    @Override
    public void init() {
        DcMotorSimple frontLeft = hardwareMap.get(DcMotorSimple.class, "frontLeft");
    }

    @Override
    public void loop() {

    }
}
