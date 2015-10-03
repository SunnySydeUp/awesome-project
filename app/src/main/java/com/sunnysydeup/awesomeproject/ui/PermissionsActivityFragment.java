package com.sunnysydeup.awesomeproject.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.sunnysydeup.awesomeproject.R;

public class PermissionsActivityFragment extends Fragment {
    private static final int REQUEST_CODE_INTERNET = 0;
    private WebView webView;

    public PermissionsActivityFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView = (WebView) view.findViewById(R.id.web_permissions);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                // request missing internet connection
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, REQUEST_CODE_INTERNET);
            } else {
                // permission granted
                loadUrl();
            }
        } else {
            loadUrl();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE_INTERNET && grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            loadUrl();
        }
    }

    private void loadUrl() {
        webView.loadUrl("http://www.google.com.au");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_permissions, container, false);
    }
}
