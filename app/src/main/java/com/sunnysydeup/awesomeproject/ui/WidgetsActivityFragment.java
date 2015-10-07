package com.sunnysydeup.awesomeproject.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sunnysydeup.awesomeproject.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class WidgetsActivityFragment extends Fragment {

    public WidgetsActivityFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextInputLayout textInputLabel = (TextInputLayout) view.findViewById(R.id.textinput_label);
        final EditText editLabel = (EditText) view.findViewById(R.id.edit_label);
        Button buttonSetError = (Button) view.findViewById(R.id.button_set_error);
        buttonSetError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInputLabel.setError(getString(R.string.set_error));
            }
        });
        Button buttonClearError = (Button) view.findViewById(R.id.button_clear_error);
        buttonClearError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textInputLabel.setError(null);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_widgets, container, false);
    }
}
