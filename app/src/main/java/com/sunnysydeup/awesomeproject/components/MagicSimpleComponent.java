package com.sunnysydeup.awesomeproject.components;

import com.sunnysydeup.awesomeproject.models.CustomScope;
import com.sunnysydeup.awesomeproject.presenters.Dagger2Presenter;

import dagger.Component;

/**
 * Created by sunny.phung on 30/1/17.
 */
@CustomScope
@Component(dependencies = {MagicBoxComponent.class, SimpleComponent.class})
public interface MagicSimpleComponent {
    void inject(Dagger2Presenter dagger2Presenter);
}
