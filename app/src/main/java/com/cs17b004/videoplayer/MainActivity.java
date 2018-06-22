package com.cs17b004.videoplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
           MediaPlayer mp;
           AudioManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     // VideoView v=(VideoView)findViewById(R.id.videoView);
       // v.setVideoPath("android.resource//"+getPackageName()+R.raw.video);
      //  v.start();
        mp =MediaPlayer.create(this,R.raw.audio);
        Button play=(Button)findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        Button pause=(Button)findViewById(R.id.button2);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mp.pause();
            }
        });
        Button stop=(Button)findViewById(R.id.button3);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
        //SeekBar sb= (SeekBar)findViewById(R.id.seekBar);
        //am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        SeekBar sb = (SeekBar)findViewById(R.id.seekBar);
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        Log.d("Current Volume", ""+currentVolume);
        Log.d("Max Valume",""+maxVolume);

        sb.setMax(maxVolume);
        sb.setProgress(currentVolume);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Progress : ", ""+progress+" : "+fromUser);

                am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
