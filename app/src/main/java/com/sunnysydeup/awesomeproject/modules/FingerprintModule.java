package com.sunnysydeup.awesomeproject.modules;

import android.app.Activity;
import android.content.Context;

import com.afollestad.digitus.Digitus;
import com.afollestad.digitus.DigitusCallback;
import com.sunnysydeup.awesomeproject.R;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunny on 26/11/2015.
 */
@Module
public class FingerprintModule {
    private final DigitusCallback callback;
    private final Activity context;
    public static final int REQUEST_CODE = 1;

    public FingerprintModule(Activity context, DigitusCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    @Provides
    public Digitus providesDigitus() {
        return Digitus.init(context, context.getString(R.string.app_name), REQUEST_CODE, callback);
    }
}
