package com.sunnysydeup.awesomeproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sunnysydeup.awesomeproject.R;

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonPermissions = (Button) view.findViewById(R.id.button_permissions);
        buttonPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPermissions();
            }
        });
        Button buttonNavigationDrawer = (Button) view.findViewById(R.id.button_navigation_drawer);
        buttonNavigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNavigationDrawer();
            }
        });
        Button buttonWidgets = (Button) view.findViewById(R.id.button_widgets);
        buttonWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToWidgets();
            }
        });
    }

    private void navigateToWidgets() {
        Intent intent = new Intent(getActivity(), WidgetsActivity.class);
        startActivity(intent);
    }

    private void navigateToPermissions() {
        Intent intent = new Intent(getActivity(), PermissionsActivity.class);
        startActivity(intent);
    }

    private void navigateToNavigationDrawer() {
        Intent intent = new Intent(getActivity(), NavigationDrawerActivity.class);
        startActivity(intent);
    }
}
