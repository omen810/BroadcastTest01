package com.omen.broadcasttest01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/14.
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("kkk", "onReceive: ---------------------");
        Toast.makeText(context, "启动完毕！", Toast.LENGTH_LONG).show();
    }
}
