package com.example.douanetemporelle;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verification);

        //recuperer variables li tb3tho mn MainActivity
        String nom = getIntent().getStringExtra( MainActivity.cle("7264","NOM_VOYAGEUR"));
        int naissance = getIntent().getIntExtra( MainActivity.cle(MainActivity.MATRICULE,"ANNEE_NAISSANCE"),0);
        int destination = getIntent().getIntExtra(MainActivity.cle(MainActivity.MATRICULE, "ANNEE_DESTINATION"),0);
        int ageTemporel = destination - naissance;


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}