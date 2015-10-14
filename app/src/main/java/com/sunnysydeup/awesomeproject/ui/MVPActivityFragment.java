package com.sunnysydeup.awesomeproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sunnysydeup.awesomeproject.R;
import com.sunnysydeup.awesomeproject.presenters.ValidationPresenter;
import com.sunnysydeup.awesomeproject.views.ValidationView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MVPActivityFragment extends Fragment implements ValidationView {

    private EditText email;
    private TextInputLayout emailContainer;
    private FloatingActionButton fab;
    private EditText name;
    private ValidationPresenter presenter;

    public MVPActivityFragment() {
    }

    @Override
    public void emailInvalid() {
        emailContainer.setError("Invalid Email");
    }

    @Override
    public void emailValid() {
        emailContainer.setError(null);
    }

    @Override
    public void hideSucceedButton() {
        fab.hide();
    }

    @Override
    public void showSucceedButton() {
        fab.show();
    }

    @Override
    public void validationSucceeded() {
        Snackbar.make(getView(), "Replace with your own action", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ValidationPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mvp, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextInputLayout nameContainer = (TextInputLayout) view.findViewById(R.id.edit_name_container);
        name = (EditText) view.findViewById(R.id.edit_name);
        emailContainer = (TextInputLayout) view.findViewById(R.id.edit_email_container);
        email = (EditText) view.findViewById(R.id.edit_email);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validate();
            }
        });
        presenter.setupValidationObservers(name, email);
    }

    @Override
    public void onDestroy() {
        presenter = null;
        super.onDestroy();
    }
}
