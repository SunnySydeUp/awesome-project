package com.sunnysydeup.awesomeproject.presenters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.graphics.Palette;

import com.sunnysydeup.awesomeproject.models.PaletteData;
import com.sunnysydeup.awesomeproject.views.PaletteView;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by sunny.phung on 6/11/15.
 */
public class PalettePresenter {
    private PaletteView view;

    public PalettePresenter(PaletteView view) {
        this.view = view;
    }

    public void getData(Context context, final Uri uri) {
        Observable<Bitmap> bitmapObservable = createBitmap(context, uri);
        Observable<Palette> paletteObservable = createPalette(bitmapObservable);
        Observable.combineLatest(bitmapObservable, paletteObservable, new Func2<Bitmap, Palette, PaletteData>() {
            @Override
            public PaletteData call(Bitmap bitmap, Palette palette) {
                return new PaletteData(bitmap, palette);
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<PaletteData>() {
            @Override
            public void call(PaletteData paletteData) {
                view.paletteDataReady(paletteData);
            }
        });
    }

    private Observable<Palette> createPalette(Observable<Bitmap> bitmap) {
        return bitmap.map(new Func1<Bitmap, Palette>() {
            @Override
            public Palette call(Bitmap bitmap) {
                return Palette.from(bitmap).generate();
            }
        });
    }

    private Observable<Bitmap> createBitmap(final Context context, final Uri uri) {
        return Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }
                subscriber.onNext(bitmap);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
