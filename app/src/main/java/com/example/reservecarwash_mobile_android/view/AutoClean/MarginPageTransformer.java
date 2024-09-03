package com.example.reservecarwash_mobile_android.view.AutoClean;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class MarginPageTransformer implements ViewPager.PageTransformer {
    private final int marginPx;

    public MarginPageTransformer(int marginPx) {
        this.marginPx = marginPx;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
    }
}