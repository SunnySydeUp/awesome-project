package com.sunnysydeup.awesomeproject.components;

import com.afollestad.digitus.Digitus;
import com.sunnysydeup.awesomeproject.modules.FingerprintModule;
import com.sunnysydeup.awesomeproject.presenters.FingerprintPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sunny on 26/11/2015.
 */
@Component(modules = {FingerprintModule.class})
@Singleton
public interface FingerprintComponent {
    void inject(FingerprintPresenter presenter);

    Digitus digitus();
}
