package com.sunnysydeup.awesomeproject.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.presenters.Dagger2Presenter;
import com.sunnysydeup.awesomeproject.views.Dagger2View;

/**
 * A placeholder fragment containing a simple view.
 */
public class Dagger2ActivityFragment extends Fragment implements Dagger2View {

    private Dagger2Presenter presenter;

    public Dagger2ActivityFragment() {
    }

    @Override
    public void onDestroy() {
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Dagger2Presenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dagger2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(presenter.getMagicBoxString());
    }
}
