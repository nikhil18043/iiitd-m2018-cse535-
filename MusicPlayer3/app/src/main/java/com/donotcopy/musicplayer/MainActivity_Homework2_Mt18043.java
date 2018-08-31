package com.donotcopy.musicplayer;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity_Homework2_Mt18043 extends AppCompatActivity implements View.OnClickListener {

    Button start,stop;
    Button Download;
    AssetManager assetManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__homework2__mt18043);
        start=(Button)findViewById(R.id.play);
        stop=(Button)findViewById(R.id.stop);
        Download =(Button)findViewById(R.id.downlaod);
        start.setOnClickListener((View.OnClickListener) this);
        stop.setOnClickListener((View.OnClickListener) this);
        Download.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment;
        if(view==start) {
            fragment=new List_Homework2_MT18043();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.fragment1,fragment);
            ft.commit();
            Intent intent = new Intent(this, MusicService_Homework2_MT18043.class);
            Bundle b = new Bundle();
            b.putString("song","chalti.mp3");
            intent.putExtras(b);
            startService(intent);
        }
        else if(view==stop)
        {
            stopService(new Intent(getApplicationContext(),MusicService_Homework2_MT18043.class));
        }
        else if(view==Download)
        {
            startService(new Intent(getApplicationContext(), Downloader_Homewrok2_Mt18043.class));
        }
    }
}
