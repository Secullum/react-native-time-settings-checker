package com.secullum.reactnativetimesettingschecker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import android.provider.Settings;

public class ReactNativeTimeSettingsCheckerModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private static final int ENABLED = 1;

    public ReactNativeTimeSettingsCheckerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ReactNativeTimeSettingsChecker";
    }

    @ReactMethod
    public void getAutomaticDateTimeEnabledAsync(Promise promise) {
        try {
            boolean automaticDateTimeEnabled = Settings.Global.getInt(reactContext.getContentResolver(), Settings.Global.AUTO_TIME, 0) == ENABLED;

            promise.resolve(automaticDateTimeEnabled);
        }
        catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAutomaticTimezoneEnabledAsync(Promise promise) {
        try {
            boolean automaticTimezoneEnabled = Settings.Global.getInt(reactContext.getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0) == ENABLED;

            promise.resolve(automaticTimezoneEnabled);
        }
        catch (Exception e) {
            promise.reject(e);
        }
    }
}
