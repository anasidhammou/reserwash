package com.example.reservecarwash_mobile_android.view.AutoClean.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.reservecarwash_mobile_android.R;
import com.example.reservecarwash_mobile_android.view.AutoClean.CommandeStepActivity;

import java.util.ArrayList;

import me.drozdzynski.library.steppers.SteppersItem;
import me.drozdzynski.library.steppers.SteppersView;
import me.drozdzynski.library.steppers.interfaces.OnCancelAction;
import me.drozdzynski.library.steppers.interfaces.OnChangeStepAction;
import me.drozdzynski.library.steppers.interfaces.OnFinishAction;


public class CalendarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_calendar, container, false);
        findView(view);
        return view;
    }

    private void findView(View view) {
        SteppersView.Config steppersViewConfig = new SteppersView.Config();
        steppersViewConfig.setOnFinishAction(new OnFinishAction() {
            @Override
            public void onFinish() {
                Intent i = new Intent(getContext(), CommandeStepActivity.class);
                startActivity(i);
            }
        });

        steppersViewConfig.setOnCancelAction(new OnCancelAction() {
            @Override
            public void onCancel() {

            }
        });

        steppersViewConfig.setOnChangeStepAction(new OnChangeStepAction() {
            @Override
            public void onChangeStep(int position, SteppersItem activeStep) {
            }
        });

        steppersViewConfig.setFragmentManager(getParentFragmentManager());

        ArrayList<SteppersItem> steps = new ArrayList<>();

        SteppersItem stepFirst = new SteppersItem();
        SteppersItem stepFirst1 = new SteppersItem();
        SteppersItem stepFirst2 = new SteppersItem();
        SteppersItem stepFirst3 = new SteppersItem();
        SteppersItem stepFirst4 = new SteppersItem();

        stepFirst.setLabel("Choix de créneau horaire");
        stepFirst.setSubLabel("Dans cette étape, Vous devez choisir votre créneau horaire");
        stepFirst1.setLabel("Choix de véhicule");
        stepFirst1.setSubLabel("Dans cette étape, Vous devez choisir votre véhicule pour le lavage");
        stepFirst2.setLabel("Constitution de panier");
        stepFirst2.setSubLabel("Dans cette étape, Vous devez Constituez votre panier avec les plans et abonnements choisies");
        stepFirst3.setLabel("Soumettre la commande");
        stepFirst3.setSubLabel("Dans cette étape, Vous enregistrez votre commande");
        stepFirst4.setLabel("Rendez-vous");
        stepFirst4.setSubLabel("Dans cette étape, Vous devez vous rendre au redez-vous le jour J");
        steps.add(stepFirst);
        steps.add(stepFirst1);
        steps.add(stepFirst2);
        steps.add(stepFirst3);
        steps.add(stepFirst4);

        SteppersView steppersView = view.findViewById(R.id.steppersView);
        steppersView.setConfig(steppersViewConfig);
        steppersView.setItems(steps);
        steppersView.build();
    }
}