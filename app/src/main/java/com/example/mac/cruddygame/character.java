package com.example.mac.cruddygame;

import java.io.Serializable;

/**
 * Created by Mac on 7/15/2019.
 */

public class character implements Serializable{
    protected int maxhealth;
    protected int money;
    protected int currentexp;
    protected int expCap;
    protected int currenthealth;
    protected int level;
    protected int strength;
    protected int story;



    public character(int h, int m, int c, int l, int s, int st) {
        this.maxhealth = h;
        this.money = m;
        this.currentexp = c;
        this.expCap = 5;
        this.currenthealth = h;
        this.level = l;
        this.strength = s;
        this.story = st;

    }

    public int getMaxHealth(){
        return maxhealth;
    }

    public int getCurrenthealth() {
        return currenthealth;
    };

    public int getMoney(){
        return money;
    }

    public int getCurrentexp() {
        return currentexp;
    }

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getStory() {
        return story;
    }

    public int getexpCap() {
        return expCap;
    }



    public void setMoney(int m) {
        money = m;
    }

    public void setMaxHealth (int h) {
        maxhealth = h;
    }

    public void setCurrentHealth (int h) {
        currenthealth = h;
    }

    public void setCurrentexp (int exp) {
        currentexp = exp;
    }

    public void setexpCap(int cap) {
        expCap = cap;
    }

    public void setLevel (int lvl) {
        level = lvl;
    }

    public void setStrength (int s) {
        strength = s;
    }

    public void setStory (int s) {
        story = s;
    }
}
