package com.example.myapplication;

public class Player {
    public  final String nickname;
    public final int[] attributes;

    public Player(String nickname, int[] attributes){
        this.nickname = nickname;
        this.attributes = attributes;
    }

    public void applyAttribute(int[] attrs){
        if(attrs.length == this.attributes.length){
            throw new IllegalStateException();
        }

        for(int i = 0; i < attributes.length; i++){
            attributes[i] += attrs[i];
        }
    }
}
