package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.util.ElapsedTime;

public class Switch{
    public Switch(boolean setInitialVal, int setInputTimeOut){
        setInitialVal(setInitialVal);
        setInputTimeOut(setInputTimeOut);
    }
    public Switch(boolean setInitialVal){
        setInitialVal(setInitialVal);
    }

    private boolean placeHolder = false;
    private double Wait = 1000;
    ElapsedTime timeOut = new ElapsedTime();
    public void changeBool(boolean gamepad){
        if (timeOut.milliseconds()>Wait)
            if (gamepad) {
                placeHolder = !placeHolder;
                timeOut.reset();
            }

    }
    public void changeBool(boolean gamepad1, boolean gamepad2){
        if (timeOut.milliseconds()>Wait)
            if (gamepad1 && gamepad2) {
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

    public void setInputTimeOut(double Timeout){
        Timeout = Wait;
    }
}