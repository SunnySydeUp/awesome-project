package com.sunnysydeup.awesomeproject.presenters;

import com.sunnysydeup.awesomeproject.components.DaggerMagicBoxComponent;
import com.sunnysydeup.awesomeproject.components.DaggerMagicSimpleComponent;
import com.sunnysydeup.awesomeproject.components.DaggerSimpleComponent;
import com.sunnysydeup.awesomeproject.components.MagicBoxComponent;
import com.sunnysydeup.awesomeproject.components.MagicSimpleComponent;
import com.sunnysydeup.awesomeproject.components.SimpleComponent;
import com.sunnysydeup.awesomeproject.models.MagicBox;
import com.sunnysydeup.awesomeproject.models.SimpleModel;
import com.sunnysydeup.awesomeproject.views.Dagger2View;

import javax.inject.Inject;

/**
 * Created by sunny.phung on 4/11/15.
 */
public class Dagger2Presenter {
    private final Dagger2View view;
    @Inject
    public MagicBox magicBox;
    @Inject
    public SimpleModel simpleModel;

    public Dagger2Presenter(Dagger2View view) {
        this.view = view;
        MagicBoxComponent magicBoxComponent = DaggerMagicBoxComponent.builder().build();
        SimpleComponent simpleComponent = DaggerSimpleComponent.builder().build();
        MagicSimpleComponent component = DaggerMagicSimpleComponent.builder().magicBoxComponent(magicBoxComponent).simpleComponent(simpleComponent).build();
        component.inject(this);
    }

    public String getMagicBoxString() {
        return magicBox.toString() + " " + simpleModel.toString();
    }
}
