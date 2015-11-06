package com.sunnysydeup.awesomeproject.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.models.PaletteData;
import com.sunnysydeup.awesomeproject.presenters.PalettePresenter;
import com.sunnysydeup.awesomeproject.views.PaletteView;

public class PaletteResultActivity extends AppCompatActivity implements PaletteView {

    private View loadingFrame;
    private PalettePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new PalettePresenter(this);

        Bundle data = getIntent().getExtras();
        Uri byteArray = data.getParcelable("image");
        presenter.getData(this, byteArray);

        loadingFrame = findViewById(R.id.loading_frame);
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void paletteDataReady(PaletteData paletteData) {
        loadingFrame.setVisibility(View.GONE);
    }
}
