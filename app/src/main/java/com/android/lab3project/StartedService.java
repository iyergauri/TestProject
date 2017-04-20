package com.android.lab3project;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.widget.Toast;

public class StartedService extends Service {
    public StartedService() {
    }

    final class ServiceThread implements Runnable
    {
        int startId;
        public ServiceThread(int startId) {
            this.startId = startId;
        }
        @Override
        public void run() {
            SharedPreferences prefs = getSharedPreferences("newPrefs", MODE_PRIVATE);
            SharedPreferences.Editor edit = prefs.edit();
            edit.putString("name", "Example Name");
            edit.apply();

            synchronized (this) {
                try {
                    wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stopSelf(startId);
            }
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(StartedService.this, "Service Started", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new ServiceThread(startId));
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(StartedService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
