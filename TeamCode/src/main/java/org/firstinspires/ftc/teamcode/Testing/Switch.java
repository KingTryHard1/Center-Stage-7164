package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.util.ElapsedTime;

public class Switch{
    boolean placeHolder = false;
    double Wait = 1;
    ElapsedTime timeOut = new ElapsedTime();
    public void changeBool(boolean gamepad){
        if (timeOut.milliseconds()>Wait)
            if (gamepad) {
                placeHolder = !placeHolder;
                timeOut.reset();
            }

    }

    public boolean returnBool(){
        return placeHolder;
    }

    public void setInitialVal(boolean initial){
        placeHolder = initial;
    }

    public void setWait(double wait){
        wait = this.Wait;
    }
}