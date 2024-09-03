package com.example.reservecarwash_mobile_android.view.AutoClean;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.reservecarwash_mobile_android.R;
import com.example.reservecarwash_mobile_android.view.AutoClean.Fragment.CalendarFragment;
import com.example.reservecarwash_mobile_android.view.AutoClean.Fragment.DecouvrirFragment;
import com.example.reservecarwash_mobile_android.view.AutoClean.Fragment.HomeFragment;
import com.example.reservecarwash_mobile_android.view.AutoClean.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeAutoCleanActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_auto_clean);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new DecouvrirFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        int id = item.getItemId();
        if(id == R.id.home){
            fragment = new DecouvrirFragment();
        }else if(id == R.id.calendar){
            fragment = new CalendarFragment();
        }else if(id == R.id.profile){
            fragment = new ProfileFragment();
        }else if(id == R.id.decouvrir){
            fragment = new HomeFragment();
        }
        if (fragment != null) {
            loadFragment(fragment);
        }
        return true;
    }

}