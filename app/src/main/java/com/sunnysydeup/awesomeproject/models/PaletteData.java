package com.sunnysydeup.awesomeproject.models;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

/**
 * Created by sunny.phung on 6/11/15.
 */
public class PaletteData {
    public Bitmap bitmap;
    public Palette palette;

    public PaletteData(Bitmap bitmap, Palette palette) {
        this.bitmap = bitmap;
        this.palette = palette;
    }
}
