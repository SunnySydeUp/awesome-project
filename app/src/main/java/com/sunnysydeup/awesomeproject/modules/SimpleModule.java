package com.sunnysydeup.awesomeproject.modules;

import com.sunnysydeup.awesomeproject.models.SimpleModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunny.phung on 30/1/17.
 */
@Module
public class SimpleModule {
    @Provides
    public SimpleModel providesSimpleModel() {
        return new SimpleModel();
    }
}
