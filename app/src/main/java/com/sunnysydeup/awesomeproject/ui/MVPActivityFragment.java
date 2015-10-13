package com.sunnysydeup.awesomeproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.presenters.ValidationPresenter;
import com.sunnysydeup.awesomeproject.presenters.ValidationPresenterImpl;

/**
 * A placeholder fragment containing a simple view.
 */
public class MVPActivityFragment extends Fragment implements ValidationPresenter.Callback {

    private FloatingActionButton fab;
    private ValidationPresenter presenter;

    public MVPActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ValidationPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mvp, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validate();
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void validationSucceeded() {
        Snackbar.make(getView(), "Replace with your own action", Snackbar.LENGTH_LONG).show();
    }
}
