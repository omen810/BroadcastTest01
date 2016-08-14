package com.omen.broadcasttest01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            /*android的后台运行在很多service，它们在系统启动时被SystemServer开启，支持系统的正常工作，
            比如MountService监听是否有SD卡安装及移除，ClipboardService提供剪切板功能，PackageManagerService
            提供软件包的安装移除及查看等等，应用程序可以通过系统提供的Manager接口来访问这些Service提供的数据。
    getSystemService是Android很重要的一个API，它是Activity的一个方法，根据传入的NAME来取得对应的Object，
    然后转换成相应的服务对象。以下介绍系统相应的服务。*/
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null&&networkInfo.isAvailable()){
                Toast.makeText(context, "网络已可用！", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "网络不可用！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
}
