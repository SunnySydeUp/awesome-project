package com.sunnysydeup.awesomeproject.presenters;

import android.widget.EditText;

public interface ValidationPresenter {
    void setupValidationObservers(EditText name, EditText email);
    void validate();
}
