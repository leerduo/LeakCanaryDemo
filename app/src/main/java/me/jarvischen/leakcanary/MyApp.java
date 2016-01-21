package me.jarvischen.leakcanary;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

public class MyApp extends Application {

    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context){
        MyApp app = (MyApp) context.getApplicationContext();
        return app.refWatcher;
    }


    @Override public void onCreate() {
        super.onCreate();
        enabledStrictMode();
        refWatcher = LeakCanary.install(this);
    }




    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }
}