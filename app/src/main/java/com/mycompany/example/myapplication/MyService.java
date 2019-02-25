package com.mycompany.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    
    private static final String TAG = MyService.class.getSimpleName();
    
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: Creating MyService");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: Executing some work");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: Destroying MyService");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new LocalBinder();
    }

    public class LocalBinder extends Binder{
        MyService getSerVice(){
            return MyService.this;
        }
    }
}
