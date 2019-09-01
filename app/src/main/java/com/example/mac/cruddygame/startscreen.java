package com.example.mac.cruddygame;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class startscreen extends AppCompatActivity {
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gangstasparadise);

        mediaPlayer.start();

        final ImageButton newbutton = (ImageButton) findViewById(R.id.newbutton);
        final ImageButton loadbutton = (ImageButton) findViewById(R.id.loadbutton);

        loadbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Gson gson = new Gson();
                    FileInputStream is = openFileInput("savefile.txt");
                    InputStreamReader isr = new InputStreamReader(is);

                    JsonReader reader = new JsonReader(isr);
                    character c = gson.fromJson(reader, character.class);
                    //Log.d("m", "what is up homie" + h.toString());
                    Intent intent = new Intent(startscreen.this, MainActivity.class);
                    intent.putExtra("character", c);
                    startActivity(intent);
                } catch (FileNotFoundException e) {
                    Toast.makeText(getBaseContext(),
                            "No Save File Found", Toast.LENGTH_LONG).show();
                }
            }
        });

        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character c = new character(15, 0, 0,1, 1, 0);
                Intent intent = new Intent(startscreen.this, MainActivity.class);
                intent.putExtra("character", c);
                startActivity(intent);
            }
        });





    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }
}
