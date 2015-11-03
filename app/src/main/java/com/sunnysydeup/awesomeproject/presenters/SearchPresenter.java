package com.sunnysydeup.awesomeproject.presenters;

import com.sunnysydeup.awesomeproject.views.SearchView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SearchPresenter {
    private ArrayList<String> list;
    private final SearchView view;

    public SearchPresenter(SearchView view) {
        this.view = view;
        setup();
    }

    private void setup() {
        list = new ArrayList<>();
        list.add("Curragundi Road");
        list.add("Easy Road");
        list.add("McLaren Street");
        list.add("Broad Street");
        list.add("Desolate Place");
        list.add("Indigo Place");
    }

    public void handleSearch(final String query) {
        Observable.from(list)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s.contains(query.trim());
                    }
                })
                .toSortedList()
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        view.showResults(strings);
                    }
                });
    }
}
