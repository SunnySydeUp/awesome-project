package com.sunnysydeup.awesomeproject.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.models.PaletteData;
import com.sunnysydeup.awesomeproject.presenters.PalettePresenter;
import com.sunnysydeup.awesomeproject.views.PaletteView;

public class PaletteResultActivity extends AppCompatActivity implements PaletteView {

    public static final String EXTRA_BITMAP = "IMAGE";
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView imageView;
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

        loadingFrame = findViewById(R.id.loading_frame);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        imageView = (ImageView) findViewById(R.id.image);

        Bundle data = getIntent().getExtras();
        Uri byteArray = data.getParcelable(EXTRA_BITMAP);
        presenter.getData(this, byteArray);
    }

    @Override
    protected void onDestroy() {
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void paletteDataReady(PaletteData paletteData) {
        loadingFrame.setVisibility(View.GONE);
        updateToolbar(paletteData);
    }

    private void updateToolbar(PaletteData paletteData) {
        imageView.setImageBitmap(paletteData.bitmap);
        collapsingToolbar.setContentScrimColor(paletteData.palette.getMutedColor(ContextCompat.getColor(this, R.color.primary)));
        collapsingToolbar.setStatusBarScrimColor(paletteData.palette.getDarkMutedColor(ContextCompat.getColor(this, R.color.primary_dark)));
        collapsingToolbar.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));
    }
}
