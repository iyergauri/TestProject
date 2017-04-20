package lab3.android.com.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;

public class DemoBindService extends Service {
    private final IBinder iBinder = new LocalService();
    public DemoBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iBinder;
    }

    public String getFirstMessage() {
        return "This is the first message.";
    }

    public String getSecondMessage() {
        return "This is the second message.";
    }


    class LocalService extends Binder {
        public DemoBindService getService() {
            return DemoBindService.this;
        }

    }
}
