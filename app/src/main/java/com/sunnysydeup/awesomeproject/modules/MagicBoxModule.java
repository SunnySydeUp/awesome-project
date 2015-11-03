package com.sunnysydeup.awesomeproject.modules;

import com.sunnysydeup.awesomeproject.models.MagicBox;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunny.phung on 4/11/15.
 */
@Module
public class MagicBoxModule {
    @Provides
    @Singleton
    public MagicBox providesMagicBox() {
        return new MagicBox();
    }
}
