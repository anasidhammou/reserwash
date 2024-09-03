package com.example.reservecarwash_mobile_android.view.AutoClean;


import android.view.View;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.MarginPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class CompositePageTransformer implements ViewPager.PageTransformer {
    private final List<ViewPager.PageTransformer> transformers = new ArrayList<>();
    private int marginPxx;

    public void addTransformer(ViewPager.PageTransformer transformer, int marginPx) {
        transformers.add(transformer);
        this.marginPxx = marginPx;
    }



    @Override
    public void transformPage(View page, float position) {
        for (ViewPager.PageTransformer transformer : transformers) {
            transformer.transformPage(page, position);
        }
    }
}
