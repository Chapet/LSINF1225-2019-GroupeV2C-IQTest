package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.app.Application;

public class IQWhizzApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.createInstance(getApplicationContext());
    }
}
