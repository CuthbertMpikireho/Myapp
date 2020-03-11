package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

public class cuthbert1 extends AppCompatActivity {

    MediaPlayer mPlay;
    Button play, pause,end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuthbert1);
        play=(Button)findViewById(R.id.playbtn);
        pause=(Button)findViewById(R.id.btnPause);
        end=(Button)findViewById(R.id.stopbtn);
        //creating media player
        final MediaPlayer mp=new MediaPlayer();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(cuthbert1.this,R.raw.perfect);
                mediaPlayer.start();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlay != null && mPlay.isPlaying()){
                    mPlay.stop();
                }
            }
        });
    }

    }

