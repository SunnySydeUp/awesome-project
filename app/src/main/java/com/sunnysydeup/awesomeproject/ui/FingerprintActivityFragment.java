package com.sunnysydeup.awesomeproject.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.presenters.FingerprintPresenter;
import com.sunnysydeup.awesomeproject.views.FingerprintView;

/**
 * A placeholder fragment containing a simple view.
 */
public class FingerprintActivityFragment extends Fragment implements FingerprintView {

    private TextView authorised;
    private FingerprintPresenter presenter;

    public FingerprintActivityFragment() {
    }

    @Override
    public void authenticated(boolean authorised) {
        if (authorised) {
            this.authorised.setText(getString(R.string.authenticated));
            this.authorised.setTextColor(ContextCompat.getColor(getActivity(), R.color.palette_green));
        } else {
            this.authorised.setText(getString(R.string.unauthenticated));
            this.authorised.setTextColor(ContextCompat.getColor(getActivity(), R.color.palette_red));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        presenter.handlePermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new FingerprintPresenter(this, (FingerprintActivity) getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fingerprint, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authorised = (TextView) view.findViewById(R.id.authorised);
        Button authenticate = (Button) view.findViewById(R.id.authenticate);
        authenticate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.authenticate();
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.finish();
        presenter = null;
        super.onDestroy();
    }
}
