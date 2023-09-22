package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.CRServo
import com.qualcomm.robotcore.hardware.DcMotorEx

abstract class DriveConstance: OpMode(){

    var frontLeft: DcMotorEx? = null
    var frontRight: DcMotorEx? = null
    var backLeft: DcMotorEx? = null
    var backRight: DcMotorEx? = null

    var crane: DcMotorEx? = null
    var lefts: CRServo? = null

    fun initRobot(){
        frontLeft = hardwareMap.get(DcMotorEx::class.java, "frontLeft")
        frontRight = hardwareMap.get(DcMotorEx::class.java, "frontRight")
        backLeft = hardwareMap.get(DcMotorEx::class.java, "backLeft")
        backRight = hardwareMap.get(DcMotorEx::class.java, "backRight")

        crane = hardwareMap.get(DcMotorEx::class.java, "crane")
        lefts = hardwareMap.get(CRServo::class.java, "lefts")

    }


}
