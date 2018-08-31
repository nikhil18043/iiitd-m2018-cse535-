package com.donotcopy.musicplayer;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Downloader_Homewrok2_Mt18043 extends Service {
    DownloadManager dm;
    Boolean wificonnect,mobileconnect;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String status="";
        ConnectivityManager conn_manager=(ConnectivityManager)getSystemService(Service.CONNECTIVITY_SERVICE);
        NetworkInfo nwinfo=conn_manager.getActiveNetworkInfo();
        if((nwinfo!=null)&&(nwinfo.isConnected()))
        {
            wificonnect=nwinfo.getType()==ConnectivityManager.TYPE_WIFI;
            mobileconnect=nwinfo.getType()==ConnectivityManager.TYPE_MOBILE;
            if(wificonnect)
                status="wifi connected";
            else if(mobileconnect)
                status="Mobile Connected";
            Toast.makeText(this,status, Toast.LENGTH_SHORT).show();
        }
        if(status=="") {
            Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show();
            onDestroy();
        }
        else if(status!="Not Connected")
        {
            dm=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri=Uri.parse("http://faculty.iiitd.ac.in/~mukulika/s1.mp3");
            DownloadManager.Request req=new DownloadManager.Request(uri);
            req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            req.setDestinationInExternalFilesDir(this,Environment.DIRECTORY_DOWNLOADS,"s1.mp3");
            Long refer=dm.enqueue(req);
        }
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
