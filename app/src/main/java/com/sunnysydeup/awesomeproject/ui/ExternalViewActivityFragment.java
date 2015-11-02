package com.sunnysydeup.awesomeproject.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunnysydeup.awesomeproject.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExternalViewActivityFragment extends Fragment {

    public ExternalViewActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_external_view, container, false);
    }
}
