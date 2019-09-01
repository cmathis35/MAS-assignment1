package com.example.mac.cruddygame;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private enemy e;
    private int gobackto = 0;
    Map<String, Integer> screens = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        screens.put("main", 0);
        screens.put("story", 1);
        screens.put("explore", 2);
        screens.put("fight", 3);
        screens.put("character", 4);
        screens.put("stats", 5);
        screens.put("shop", 6);
        screens.put("weaponshop", 7);
        screens.put("armorshop", 8);
        screens.put("spellshop", 9);
        screens.put("trainingshop", 10);


        final character c = (character) getIntent().getSerializableExtra("character");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewFlipper screen = findViewById(R.id.screen);

        final ImageButton explorebutton = findViewById(R.id.exploreButton);
        final ImageButton savebutton = findViewById(R.id.saveButton);
        final ImageView character = findViewById(R.id.character);
        final TextView level = findViewById(R.id.level);
        final TextView savestate = findViewById(R.id.saveState);
        final ImageButton goback =  findViewById(R.id.goBack);
        final ImageButton gobacktoexplore = findViewById(R.id.goBackToExplore);
        final ImageButton gobacktomain = findViewById(R.id.goBackToMain);
        final TextView enemyhealth =  findViewById(R.id.enemyhealth);
        final ImageButton hitbutton =  findViewById(R.id.hitButton);
        final TextView cash = findViewById(R.id.cash);
        //final ImageButton marketbutton = findViewById(R.id.marketbutton);
        final TextView health = findViewById(R.id.hp);
        final ImageButton innbutton = findViewById(R.id.innButton);
        final TextView storybox = findViewById(R.id.storybox);
        final ImageButton storybutton = findViewById(R.id.storybutton);
        final ImageButton hutbutton = findViewById(R.id.hutbutton);
        final ImageButton forestbutton = findViewById(R.id.forestbutton);
        final TextView level2 = findViewById(R.id.level2);
        final TextView enemyname = findViewById(R.id.enemyname);
        final TextView cash2 = findViewById(R.id.cash2);
        final TextView hp2 = findViewById(R.id.hp2);

        final ImageButton weaponshop = findViewById(R.id.weaponshop);
        final ImageButton armorshop = findViewById(R.id.armorshop);
        final ImageButton spellshop = findViewById(R.id.spellshop);
        final ImageButton trainingshop = findViewById(R.id.trainingshop);


        savestate.setVisibility(View.GONE);
        screen.setDisplayedChild(1);

        level.setText("Level: " + String.valueOf(c.getLevel()));
        cash.setText("Gold: " + String.valueOf(c.getMoney()));
        health.setText(String.valueOf(c.getCurrenthealth()) + '/' + String.valueOf(c.getMaxHealth()));

        getStringResourceByName("story" + c.getStory());
        storybox.setText(getStringResourceByName("story" + c.getStory()));
        c.setStory(c.getStory() + 1);



        explorebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setDisplayedChild(screens.get("explore"));
            }
        });

        storybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (c.getStory()) {
                    case 0: case 1: case 2: case 3: case 4: case 5:
                        storybox.setText(getStringResourceByName("story" + c.getStory()));
                        c.setStory(c.getStory() + 1);
                        break;
                    case 6:
                        c.setStory(c.getStory() + 1);
                        screen.setDisplayedChild(0);
                        break;
                    case 7:
                        storybox.setText(getStringResourceByName("story" + c.getStory()));
                        c.setStory(c.getStory() + 1);
                        screen.setDisplayedChild(screens.get("main"));
                        break;
                    case 8:
                        storybox.setText("FINISH YOUR CURRENT MISSION");
                        c.setStory(c.getStory());
                        screen.setDisplayedChild(screens.get("main"));
                        break;
                    case 9:
                        c.setStory(c.getStory() - 1);
                        screen.setDisplayedChild(0);
                        break;


                }
            }
        });

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character.setVisibility(View.GONE);
                innbutton.setVisibility(View.GONE);
                explorebutton.setVisibility(View.GONE);
                health.setVisibility(View.GONE);
                cash.setVisibility(View.GONE);
                level.setVisibility(View.GONE);
                //marketbutton.setVisibility(View.GONE);
                savebutton.setVisibility(View.GONE);
                hutbutton.setVisibility(View.GONE);
                savestate.setVisibility(View.VISIBLE);
                goback.setVisibility(View.VISIBLE);

                //JSON PARSING DONE HERE
                try {
                    FileOutputStream fos = openFileOutput("savefile.txt", Context.MODE_PRIVATE);
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = new Gson();
                    fos.write(gson.toJson(c).getBytes());
                    fos.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback.setVisibility(View.GONE);
                savestate.setVisibility(View.GONE);
                explorebutton.setVisibility(View.VISIBLE);
                savebutton.setVisibility(View.VISIBLE);
                character.setVisibility(View.VISIBLE);
                level.setVisibility(View.VISIBLE);
                cash.setVisibility(View.VISIBLE);
                health.setVisibility(View.VISIBLE);
                innbutton.setVisibility(View.VISIBLE);
                hutbutton.setVisibility(View.VISIBLE);
                //marketbutton.setVisibility(View.VISIBLE);

            }
        });

        gobacktoexplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gobacktoexplore.setVisibility(View.GONE);
                screen.setDisplayedChild(screens.get("explore"));
            }
        });


        gobacktomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setDisplayedChild(screens.get("main"));
            }
        });



        hitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.setcurrentHealth(e.getcurrentHealth() - c.getStrength());
                c.setCurrentHealth(c.getCurrenthealth() - e.getStrength());
                health.setText(String.valueOf(c.getCurrenthealth()) + " / " + c.getMaxHealth());
                hp2.setText(String.valueOf(c.getCurrenthealth()));
                enemyhealth.setText(String.valueOf(e.getcurrentHealth()) + " / " + e.getmaxHealth());
                if (c.getCurrenthealth() <= 0){
                    level2.setVisibility(View.VISIBLE);
                    level2.setText("You Lose, Reload last save?");
                    gobacktoexplore.setVisibility(View.VISIBLE);

                } else if (e.getcurrentHealth() <= 0) {
                    hitbutton.setVisibility(View.GONE);
                    enemyhealth.setText("You Win!");
                    gobacktoexplore.setVisibility(View.VISIBLE);
                    c.setMoney(c.getMoney() + 1);
                    cash2.setText("Gold: " + String.valueOf(c.getMoney()));
                    cash.setText("Gold: " + String.valueOf(c.getMoney()));
                    c.setCurrentexp(c.getCurrentexp() + e.getexp());
                    while(c.getCurrentexp() >= c.getexpCap()) {
                        enemyhealth.setText("You have gained a level");
                        c.setLevel(c.getLevel() + 1);
                        c.setStrength(c.getStrength() + 1);
                        c.setMaxHealth(c.getMaxHealth() + 5);
                        c.setCurrentHealth(c.getMaxHealth());

                        c.setCurrentexp(c.getCurrentexp() - c.getexpCap());
                        level.setText("Level: " + String.valueOf(c.getLevel()));
                        level2.setText("Level: " + String.valueOf(c.getLevel()));
                        cash.setText("Gold: " + String.valueOf(c.getMoney()));
                        cash2.setText("Gold: " + String.valueOf(c.getMoney()));
                        health.setText(String.valueOf(c.getCurrenthealth()) + '/' + String.valueOf(c.getMaxHealth()));
                        hp2.setText(String.valueOf(c.getCurrenthealth()) + '/' + String.valueOf(c.getMaxHealth()));


                    }
                    //hitbutton.setVisibility(View.GONE);
                } else {

                }


            }
        });



        innbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.setCurrentHealth(c.getMaxHealth());
                health.setText(String.valueOf(c.getCurrenthealth()) + '/' + String.valueOf(c.getMaxHealth()));
                character.setVisibility(View.GONE);
                innbutton.setVisibility(View.GONE);
                explorebutton.setVisibility(View.GONE);
                health.setVisibility(View.GONE);
                cash.setVisibility(View.GONE);
                level.setVisibility(View.GONE);
                //marketbutton.setVisibility(View.GONE);
                savebutton.setVisibility(View.GONE);
                hutbutton.setVisibility(View.GONE);

                goback.setVisibility(View.VISIBLE);
                Toast toast= Toast.makeText(getApplicationContext(),
                        "Health Restored", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });


        hutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setDisplayedChild(screens.get("story"));
                storybox.setText(getStringResourceByName("story" + c.getStory()));
            }
        });


        //marketbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                screen.setDisplayedChild(screens.get("shop"));
//
//            }
//        });

        weaponshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setDisplayedChild(screens.get("weaponshop"));

            }
        });

        armorshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setDisplayedChild(screens.get("armorshop"));

            }
        });

        spellshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setDisplayedChild(screens.get("spellshop"));

            }
        });

        trainingshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setDisplayedChild(screens.get("trainingshop"));

            }
        });





        /*
        * Button clicks for Explore map
        *
        * */

        forestbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e = new enemy("Grassland");
                enemyname.setText(e.getName());
                enemyhealth.setText(String.valueOf(e.getcurrentHealth()) + " / " + e.getmaxHealth());
                screen.setDisplayedChild(screens.get("fight"));
                cash2.setText("Gold: " + String.valueOf(c.getMoney()));
                level2.setText("Level: " + String.valueOf(c.getLevel()));
                hp2.setText(String.valueOf(c.getCurrenthealth()) + '/' + String.valueOf(c.getMaxHealth()));
                hitbutton.setVisibility(View.VISIBLE);
                gobacktoexplore.setVisibility(View.GONE);
                gobackto = screens.get("explore");

            }
        });




    }



    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }


}
