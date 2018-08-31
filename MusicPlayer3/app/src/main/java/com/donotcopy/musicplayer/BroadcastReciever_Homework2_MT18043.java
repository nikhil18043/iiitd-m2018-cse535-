package com.donotcopy.musicplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReciever_Homework2_MT18043 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
        if(isAirplaneModeOn){
            Toast.makeText(context,"Airplane mode is on",Toast.LENGTH_SHORT).show();
            // AP mode is on
        } else {
            Toast.makeText(context,"Airplane mode is off",Toast.LENGTH_SHORT).show();
            // AP mode is off
        }

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
