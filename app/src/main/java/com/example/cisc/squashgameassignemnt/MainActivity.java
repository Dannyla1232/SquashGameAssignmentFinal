package com.example.cisc.squashgameassignemnt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener {


    private SoundPool soundpool;
    int sample1 = -1;
    TextView textScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);

        soundpool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {


            AssetManager assetsManager = getAssets();
            AssetFileDescriptor descriptor;

            descriptor = assetsManager.openFd("Start sound.wav");
            sample1 = soundpool.load(descriptor, 0);
        } catch (IOException e) {
            Context context = getApplicationContext();
            CharSequence text = "not found";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }

    }


    @Override
    public void onClick(View v) {
        soundpool.play(sample1, 1, 1, 0, 0, 1);
        Intent i;
        i = new Intent (this, GameActivity.class);
        startActivity(i);
    }
}