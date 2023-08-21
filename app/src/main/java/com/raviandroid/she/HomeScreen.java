package com.raviandroid.she;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.media.MediaPlayer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class HomeScreen extends AppCompatActivity {

    ImageButton sirenBt;
    ImageButton help;
    ImageButton fakeBt;
    private MediaPlayer mediaPlayer;
    private boolean isResume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        mediaPlayer = MediaPlayer.create(this, R.raw.policesiren);
        sirenBt=findViewById(R.id.Button1);
        sirenBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isResume){
                    isResume=true;
                    playSiren();
                }
                else{
                    isResume=false;
                    pauseSiren();
                }
            }
        });


        help = findViewById(R.id.hlBtn);
        Intent iHelp;
        iHelp = new Intent(HomeScreen.this, helpline.class);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iHelp);
            }
        });


        ImageButton btnNext;
        btnNext = findViewById(R.id.Button5);

        Intent iNext;
        iNext = new Intent(HomeScreen.this, MainActivity.class);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iNext);
            }
        });

        fakeBt=findViewById(R.id.fakeBtn);
        Intent iFake=new Intent(HomeScreen.this, FakeCall.class);
        fakeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iFake);
            }
        });
    }


    private void playSiren() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private void pauseSiren() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }
}




