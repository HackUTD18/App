package com.mason.androidapp;

/**
 * Created by Mason on 2/24/2018.
 */

public class Enemy {
    private String name;
    private int champ;
    private int tilt;
    private String[] reasons;

    public Enemy(String name, int champ, int tilt, String[] reasons) {
        this.name = name;
        this.champ = champ;
        this.tilt = tilt;
        this.reasons = reasons;
    }


    public String getName() {
        return name;
    }

    public int getChamp() {
        return champ;
    }

    public int getTilt() {
        return tilt;
    }

    public String[] getReasons() {
        return reasons;
    }
}
