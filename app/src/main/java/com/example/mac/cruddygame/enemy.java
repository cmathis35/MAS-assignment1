package com.example.mac.cruddygame;

/**
 * Created by Mac on 8/1/2019.
 */

public class enemy {
    private String name;
    private int maxhealth;
    private int currenthealth;
    private int strength;
    private int exp;



    public enemy(String type) {
        int RNG = (int) Math.floor(Math.random() * 1001);
        if (type == "Grassland") {
            if (RNG <= 250) {
                name = "Spider";
                maxhealth = 10;
                currenthealth = 10;
                strength = 1;
                exp = 1;
            } else if(RNG <= 500) {
                name = "Spider2";
                maxhealth = 10;
                currenthealth = 10;
                strength = 1;
                exp = 1;
            } else if (RNG <= 750) {
                name = "Spider3";
                maxhealth = 10;
                currenthealth = 10;
                strength = 1;
                exp = 1;
            } else if (RNG <= 950) {
                name = "Spider4";
                maxhealth = 10;
                currenthealth = 10;
                strength = 1;
                exp = 1;
            } else if (RNG <= 975) {
                name = "Spider5";
                maxhealth = 10;
                currenthealth = 10;
                strength = 1;
                exp = 1;
            } else if (RNG <= 980) {
                name = "Spider6";
                maxhealth = 10;
                currenthealth = 10;
                strength = 1;
                exp = 1;
            } else {
                name = "Spider Queen";
                maxhealth = 100;
                currenthealth = 100;
                strength = 2;
                exp = 10;
            }
        } else if (type == "City") {

        }
    }


    public void hit(character c, String attacktype) {

    }

    public String getName() {
        return name;
    }

    public int getmaxHealth() {
        return maxhealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getcurrentHealth() {
        return currenthealth;
    }

    public int getexp() {
        return exp;
    }

    public void setcurrentHealth(int h) {
        currenthealth = h;
    }







































}
