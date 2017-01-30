package com.sunnysydeup.awesomeproject.components;

import com.sunnysydeup.awesomeproject.models.SimpleModel;
import com.sunnysydeup.awesomeproject.modules.SimpleModule;

import dagger.Component;

/**
 * Created by sunny.phung on 30/1/17.
 */
@Component(modules = {SimpleModule.class})
public interface SimpleComponent {
    SimpleModel simpleModel();
}
