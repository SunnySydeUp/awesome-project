package com.sunnysydeup.awesomeproject.components;

import com.sunnysydeup.awesomeproject.models.MagicBox;
import com.sunnysydeup.awesomeproject.modules.MagicBoxModule;
import com.sunnysydeup.awesomeproject.presenters.Dagger2Presenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sunny.phung on 4/11/15.
 */
@Component(modules = {MagicBoxModule.class})
@Singleton
public interface MagicBoxComponent {
    void inject(Dagger2Presenter presenter);

    MagicBox magicBox();
}
