package com.sunnysydeup.awesomeproject.ui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sunnysydeup.awesomeproject.R;

public class PermissionsActivityFragment extends Fragment implements AlertDialog.OnClickListener {
    public static final int REQUEST_CONTACT_PERMISSION_CODE = 1;

    public PermissionsActivityFragment() {
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CONTACT_PERMISSION_CODE);
    }

    @Override
    public void onResume() {
        super.onResume();
        askPermission();
    }

    private void askPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int hasReadPermission = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CONTACTS);
            if (hasReadPermission != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_CONTACTS)) {
                    new AlertDialog.Builder(getActivity())
                            .setMessage("Need read contacts")
                            .setPositiveButton("OK", this)
                            .setNegativeButton("Cancel", null)
                            .create()
                            .show();
                    return;
                }
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CONTACT_PERMISSION_CODE);
                return;
            }
        }
        readContacts();
    }

    private void readContacts() {
        Toast.makeText(getActivity(), "Read Contacts", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CONTACT_PERMISSION_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "Permission Granted", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_permissions, container, false);
    }
}
