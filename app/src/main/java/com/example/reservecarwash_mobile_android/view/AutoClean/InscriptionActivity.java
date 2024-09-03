package com.example.reservecarwash_mobile_android.view.AutoClean;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reservecarwash_mobile_android.R;

public class InscriptionActivity extends AppCompatActivity {

    LinearLayout linear_parti, linear_pro;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inscription);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroup = findViewById(R.id.radioGroup);
        linear_parti = findViewById(R.id.linear_particulier);
        linear_pro = findViewById(R.id.linear_professionnel);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.particulier) {
                    // Handle selection of Option 1
                    linear_parti.setVisibility(View.VISIBLE);
                    linear_pro.setVisibility(View.GONE);
                } else if (checkedId == R.id.professionnel) {
                    // Handle selection of Option 2
                    linear_parti.setVisibility(View.GONE);
                    linear_pro.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}