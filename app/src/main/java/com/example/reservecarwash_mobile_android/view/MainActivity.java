
package com.example.reservecarwash_mobile_android.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reservecarwash_mobile_android.R;
import com.example.reservecarwash_mobile_android.view.AutoClean.AutoCleanActivity;
import com.example.reservecarwash_mobile_android.view.Exepxion.ExepxionActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        }

    public void goExepxion(View view) {
        Intent i = new Intent(MainActivity.this, ExepxionActivity.class);
        startActivity(i);
    }

    public void goAutoClean(View view) {
        Intent i = new Intent(MainActivity.this, AutoCleanActivity.class);
        startActivity(i);
    }
}