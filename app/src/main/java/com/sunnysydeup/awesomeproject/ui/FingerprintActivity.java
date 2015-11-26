package com.sunnysydeup.awesomeproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.afollestad.digitus.FingerprintDialog;
import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.events.FingerprintEvent;

import de.greenrobot.event.EventBus;

public class FingerprintActivity extends AppCompatActivity implements FingerprintDialog.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onFingerprintDialogAuthenticated() {
        EventBus.getDefault().post(new FingerprintEvent());
    }

    @Override
    public void onFingerprintDialogVerifyPassword(FingerprintDialog fingerprintDialog, String s) {

    }

    @Override
    public void onFingerprintDialogStageUpdated(FingerprintDialog fingerprintDialog, FingerprintDialog.Stage stage) {

    }

    @Override
    public void onFingerprintDialogCancelled() {

    }
}
