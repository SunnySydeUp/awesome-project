package com.sunnysydeup.awesomeproject.views;

public interface ValidationView {
    void emailInvalid();

    void emailValid();

    void hideSucceedButton();

    void showSucceedButton();

    void validationSucceeded();
}
