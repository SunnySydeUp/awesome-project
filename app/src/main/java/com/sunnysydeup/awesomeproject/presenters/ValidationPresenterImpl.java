package com.sunnysydeup.awesomeproject.presenters;

import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;
import com.sunnysydeup.awesomeproject.views.ValidationView;

import java.util.regex.Pattern;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class ValidationPresenterImpl implements ValidationPresenter {
    private Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private ValidationView view;

    public ValidationPresenterImpl(ValidationView view) {
        this.view = view;
    }

    @Override
    public void setupValidationObservers(EditText name, EditText email) {
        Observable<Boolean> nameObservable = RxTextView.textChangeEvents(name).map(new Func1<TextViewTextChangeEvent, Boolean>() {
            @Override
            public Boolean call(TextViewTextChangeEvent textViewTextChangeEvent) {
                return !textViewTextChangeEvent.text().toString().isEmpty();
            }
        }).distinctUntilChanged();

        Observable<Boolean> emailObservable = RxTextView.textChangeEvents(email).filter(new Func1<TextViewTextChangeEvent, Boolean>() {
            @Override
            public Boolean call(TextViewTextChangeEvent textViewTextChangeEvent) {
                return textViewTextChangeEvent.text().length() > 3;
            }
        }).map(new Func1<TextViewTextChangeEvent, Boolean>() {
            @Override
            public Boolean call(TextViewTextChangeEvent textViewTextChangeEvent) {
                return emailPattern.matcher(textViewTextChangeEvent.text()).matches();
            }
        }).distinctUntilChanged();
        emailObservable.subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean valid) {
                if (valid) {
                    view.emailValid();
                } else {
                    view.emailInvalid();
                }
            }
        });

        Observable.combineLatest(nameObservable, emailObservable, new Func2<Boolean, Boolean, Boolean>() {
            @Override
            public Boolean call(Boolean nameValid, Boolean emailValid) {
                return nameValid && emailValid;
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean valid) {
                if (valid) {
                    view.showSucceedButton();
                } else {
                    view.hideSucceedButton();
                }
            }
        });
    }

    @Override
    public void validate() {
        view.validationSucceeded();
    }
}
