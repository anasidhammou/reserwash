package com.example.reservecarwash_mobile_android.view.AutoClean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservecarwash_mobile_android.R;
import com.example.reservecarwash_mobile_android.view.AutoClean.Adapter.CalendarAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CommandeStepActivity extends AppCompatActivity {

    RecyclerView calendarRecyclerView;
    CalendarAdapter calendarAdapter;
    List<Calendar> dates;
    LinearLayout Step_One, Step_Recap, Step_Confirmation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_commande_step);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Step_One = findViewById(R.id.Step_One);
        Step_Recap = findViewById(R.id.Step_Recap);
        Step_Confirmation = findViewById(R.id.Step_Validation);

        Step_One.setVisibility(View.VISIBLE);
        Step_Recap.setVisibility(View.GONE);
        Step_Confirmation.setVisibility(View.GONE);

        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);

        dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int month = calendar.get(Calendar.MONTH);
        while (calendar.get(Calendar.MONTH) == month) {
            dates.add((Calendar) calendar.clone());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        calendarAdapter = new CalendarAdapter(this, dates);

        // Set LayoutManager to be horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
    }

    public void goNextStep(View view) {

        Step_One.setVisibility(View.GONE);
        Step_Recap.setVisibility(View.VISIBLE);

    }

    public void goConfirmation(View view) {
        Step_Recap.setVisibility(View.GONE);
        Step_Confirmation.setVisibility(View.VISIBLE);
    }

    public void AddNewCar(View view) {
        Intent i = new Intent(CommandeStepActivity.this,AddNewCarActivity.class);
        startActivity(i);
    }
}