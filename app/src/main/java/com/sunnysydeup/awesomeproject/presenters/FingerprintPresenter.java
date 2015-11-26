package com.sunnysydeup.awesomeproject.presenters;

import com.afollestad.digitus.Digitus;
import com.afollestad.digitus.DigitusCallback;
import com.afollestad.digitus.DigitusErrorType;
import com.afollestad.digitus.FingerprintDialog;
import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.components.DaggerFingerprintComponent;
import com.sunnysydeup.awesomeproject.events.FingerprintEvent;
import com.sunnysydeup.awesomeproject.modules.FingerprintModule;
import com.sunnysydeup.awesomeproject.ui.FingerprintActivity;
import com.sunnysydeup.awesomeproject.views.FingerprintView;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class FingerprintPresenter implements DigitusCallback {
    private final FingerprintActivity activity;
    @Inject
    public Digitus digitus;
    private FingerprintView view;

    public FingerprintPresenter(FingerprintView view, FingerprintActivity activity) {
        this.view = view;
        this.activity = activity;
        EventBus.getDefault().register(this);
        DaggerFingerprintComponent.Builder component = DaggerFingerprintComponent.builder().fingerprintModule(new FingerprintModule(activity, this));
    }

    public void authenticate() {
        FingerprintDialog.show(activity, activity.getString(R.string.app_name), FingerprintModule.REQUEST_CODE);
    }

    public void handlePermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        digitus.handleResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onDigitusReady(Digitus digitus) {
        digitus.startListening();
    }

    @Override
    public void onDigitusListening(boolean b) {

    }

    public void onEvent(FingerprintEvent event) {
        view.authenticated(true);
    }

    @Override
    public void onDigitusAuthenticated(Digitus digitus) {
        // for permission
    }

    @Override
    public void onDigitusError(Digitus digitus, DigitusErrorType digitusErrorType, Exception e) {
        // for permission
    }

    public void finish() {
        EventBus.getDefault().unregister(this);
        Digitus.deinit();
    }
}
