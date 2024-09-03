package com.example.reservecarwash_mobile_android.view.AutoClean;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.reservecarwash_mobile_android.R;

public class PassOublieActivity extends AppCompatActivity {

    RadioButton email, phone;
    EditText mail;
    LinearLayout  phones;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pass_oublie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        radioGroup = findViewById(R.id.radioGroup);
        email = findViewById(R.id.radioButtons);
        phone = findViewById(R.id.radioButtons2);
        mail = findViewById(R.id.edtmail);
        phones = findViewById(R.id.linearPhone);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButtons) {
                    // Handle selection of Option 1
                    mail.setVisibility(View.VISIBLE);
                    phones.setVisibility(View.GONE);
                } else if (checkedId == R.id.radioButtons2) {
                    // Handle selection of Option 2
                    mail.setVisibility(View.GONE);
                    phones.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}