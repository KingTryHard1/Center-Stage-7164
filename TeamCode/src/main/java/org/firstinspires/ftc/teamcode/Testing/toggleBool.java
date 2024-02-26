package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.util.ElapsedTime;

public class toggleBool{
    public toggleBool(boolean setInitialVal, int setInputTimeOut){
        setInitialVal(setInitialVal);
        setInputTimeOut(setInputTimeOut);
    }
    public toggleBool(boolean setInitialVal){
        setInitialVal(setInitialVal);
    }

    private boolean bool = false;
    private double wait = 1000;
    ElapsedTime timeOut = new ElapsedTime();

    public boolean flipAndReturnBool(boolean gamepad){
       flipBool(gamepad);
       return bool;
    }

    public boolean flipAndReturnBool(boolean gamepad1, boolean gamepad2){
        flipBool(gamepad1, gamepad2);
        return bool;
    }

    public void flipBool(boolean gamepad){
        if (timeOut.milliseconds()>wait)
            if (gamepad) {
                bool = !bool;
                timeOut.reset();
            }
    }

    public void flipBool(){
        if (timeOut.milliseconds()>wait) {
            bool = !bool;
            timeOut.reset();
        }
    }

    public void flipBool(boolean gamepad1, boolean gamepad2){
        if (timeOut.milliseconds()>wait)
            if (gamepad1 && gamepad2) {
                bool = !bool;
                timeOut.reset();
            }
    }

    public boolean returnBool(){
        return bool;
    }

    public void setInitialVal(boolean initial){
        bool = initial;
    }

    public void setInputTimeOut(double  Timeout){
        Timeout = wait;
    }
}