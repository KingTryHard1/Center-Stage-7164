package org.firstinspires.ftc.teamcode.Testing;

public class Switch{
    boolean placeHolder = false;
    double Wait = 1;
    boolean changeBool(){
        placeHolder =! placeHolder;

        return placeHolder;
    }

    void setInitialVal(boolean initial){
        placeHolder = initial;
    }

    void setWait(double wait){
        wait = this.Wait;
    }
}