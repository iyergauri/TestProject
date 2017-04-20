package com.android.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.EditText;
import android.widget.Toast;

public class DemoService extends Service {
    public DemoService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(DemoService.this, "Service Started", Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new myThread(startId));
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        Toast.makeText(DemoService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


    final class myThread implements Runnable {
        int startId;

        public myThread(int startId) {
            this.startId = startId;
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait(15000); // Milliseconds
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf(startId);
            }
        }

    }

}
