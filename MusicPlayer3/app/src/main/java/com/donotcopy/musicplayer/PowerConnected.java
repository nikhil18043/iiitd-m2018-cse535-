package com.donotcopy.musicplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerConnected extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Toast.makeText(context,"Power-Connected",Toast.LENGTH_SHORT).show();
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
