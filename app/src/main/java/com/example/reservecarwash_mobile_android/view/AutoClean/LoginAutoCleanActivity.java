package com.example.reservecarwash_mobile_android.view.AutoClean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reservecarwash_mobile_android.R;

public class LoginAutoCleanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_auto_clean);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goHome(View view) {
            Intent i = new Intent(LoginAutoCleanActivity.this, HomeAutoCleanActivity.class);
        startActivity(i);
    }

    public void goPassOublie(View view) {
        Intent i = new Intent(LoginAutoCleanActivity.this, PassOublieActivity.class);
        startActivity(i);
    }

    public void goInscription(View view) {
        Intent i = new Intent(LoginAutoCleanActivity.this, InscriptionActivity.class);
        startActivity(i);
    }
}