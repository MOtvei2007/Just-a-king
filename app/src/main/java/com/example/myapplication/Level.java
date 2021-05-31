package com.example.myapplication;

public class Level {
    public final String text;
    public final int[] deltaYes;
    public final int[] deltaNo;

    public Level(String text, int[] deltaYes, int[] deltaNo){
        this.text = text;
        this.deltaYes = deltaYes;
        this.deltaNo = deltaNo;

    }
}
