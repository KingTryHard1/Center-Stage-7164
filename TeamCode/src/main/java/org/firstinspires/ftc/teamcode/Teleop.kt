package org.firstinspires.ftc.teamcode

class Teleop: DriveConstance(){
    override fun init() {
        initRobot()
    }

    override fun loop() {
        initRobot()
        //one player
        val throttle = gamepad1.left_stick_y.toDouble()
        val strafe = gamepad1.left_stick_x
        val turnLeft = gamepad1.left_trigger
        val turnRight = gamepad1.right_trigger

        val crane = gamepad1.right_stick_y

        /*two player

        val throttle = gamepad1.left_stick_y
        val strafe = gamepad1.left_stick_x
        val turn = gamepad1.right_stick_x

        val crane = gamepad2.right_stick_y
         */

        frontLeft!!.power = throttle


    }
}