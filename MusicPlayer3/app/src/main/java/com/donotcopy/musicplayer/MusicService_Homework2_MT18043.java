package com.donotcopy.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class MusicService_Homework2_MT18043 extends Service {
    MediaPlayer mp=new MediaPlayer();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public MusicService_Homework2_MT18043() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song;
        if(intent != null){
            Bundle bundle = intent.getExtras();
           song = bundle.getString("song");
            Log.d("nik",song);
        }
        else
            song="chalti.mp3";
        if(mp.isPlaying())
            mp.stop();
        try {
            AssetFileDescriptor afd = getAssets().openFd(song);
            mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mp.stop();
        super.onDestroy();
        mp.stop();
    }
}
