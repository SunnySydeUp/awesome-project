package com.sunnysydeup.awesomeproject.presenters;

public interface ValidationPresenter {
    void validate();

    interface Callback {
        void validationSucceeded();
    }
}
