package com.example.sunnyphung.externalview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ExternalView extends LinearLayout {

    public ExternalView(Context context) {
        this(context, null);
    }

    public ExternalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.external_view, this, true);
    }
}
