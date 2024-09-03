package com.example.reservecarwash_mobile_android.view.AutoClean.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.reservecarwash_mobile_android.R;
import com.example.reservecarwash_mobile_android.view.AutoClean.LoginAutoCleanActivity;
import com.example.reservecarwash_mobile_android.view.AutoClean.Profile.CarActivity;
import com.example.reservecarwash_mobile_android.view.AutoClean.Profile.DetailsProfileActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        findView(view);
        return view;
    }

    private void findView(View view) {
        LinearLayout lineCar = view.findViewById(R.id.goListCar);
        LinearLayout lineLogOut = view.findViewById(R.id.logout);
        LinearLayout lineprofile = view.findViewById(R.id.editProfile);
        lineCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CarActivity.class);
                startActivity(i);
            }
        });

        lineprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), DetailsProfileActivity.class);
                startActivity(i);
            }
        });

        lineLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure you want to logout this account ?")
                        .setConfirmText("Yes")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                Intent i = new Intent(getContext(), LoginAutoCleanActivity.class);
                                startActivity(i);
                            }
                        })
                        .setCancelButton("No", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
    }
}