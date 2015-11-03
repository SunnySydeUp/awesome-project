package com.sunnysydeup.awesomeproject.presenters;

import com.sunnysydeup.awesomeproject.components.DaggerMagicBoxComponent;
import com.sunnysydeup.awesomeproject.components.MagicBoxComponent;
import com.sunnysydeup.awesomeproject.models.MagicBox;
import com.sunnysydeup.awesomeproject.modules.MagicBoxModule;
import com.sunnysydeup.awesomeproject.views.Dagger2View;

import javax.inject.Inject;

/**
 * Created by sunny.phung on 4/11/15.
 */
public class Dagger2Presenter {
    private final Dagger2View view;
    @Inject
    public MagicBox magicBox;
    MagicBoxComponent component;

    public Dagger2Presenter(Dagger2View view) {
        this.view = view;
        component = DaggerMagicBoxComponent.builder().magicBoxModule(new MagicBoxModule()).build();
        component.inject(this);
    }

    public String getMagicBoxString() {
        return magicBox.toString();
    }
}
