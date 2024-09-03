package com.example.reservecarwash_mobile_android.view.AutoClean.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.reservecarwash_mobile_android.R;
import com.example.reservecarwash_mobile_android.view.AutoClean.Adapter.ImageSliderAdapter;
import com.example.reservecarwash_mobile_android.view.AutoClean.CompositePageTransformer;
import com.example.reservecarwash_mobile_android.view.AutoClean.DetailsLavageActivity;
import com.example.reservecarwash_mobile_android.view.AutoClean.MarginPageTransformer;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnMapReadyCallback {
    private MapView mapView;
    private GoogleMap gMap;
    private ViewPager imageSlider;
    private ImageSliderAdapter adapter;

    private EditText search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        findView(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = view.findViewById(R.id.mapView);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        imageSlider = view.findViewById(R.id.imageSlider);
        adapter = new ImageSliderAdapter(getContext(), getImageList());
        imageSlider.setAdapter(adapter);

        imageSlider.setClipToPadding(false);
        imageSlider.setClipChildren(false);
        imageSlider.setOffscreenPageLimit(3);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = Math.abs(position);
                page.setScaleY(0.85f + r + 0.15f);
            }
        }, 40);

        imageSlider.setPageTransformer(true, compositePageTransformer);


    }

    private void findView(View v) {

        search = v.findViewById(R.id.searchEditText);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), DetailsLavageActivity.class);
                startActivity(i);
            }
        });
    }

    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        LatLng sydney = new LatLng(33.5986627, -7.613942);
        gMap.addMarker(new MarkerOptions().position(sydney).title("Ici c'est Casablanca"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        gMap.moveCamera(CameraUpdateFactory.zoomIn());
    }

    private List<String> getImageList() {
        List<String> imageList = new ArrayList<>();
        imageList.add("https://dev.reservecarwash.com/assets/banners/autoclean-banner.png");
        imageList.add("https://intranet.autocleanexpress.com/api/public/images/centres/5.jpg");
        imageList.add("https://intranet.autocleanexpress.com/api/public/images/centres/6.jpg");
        return imageList;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }


}