package com.sunnysydeup.awesomeproject.presenters;

public class ValidationPresenterImpl implements ValidationPresenter {
    private Callback callback;

    public ValidationPresenterImpl(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void validate() {
        callback.validationSucceeded();
    }
}
