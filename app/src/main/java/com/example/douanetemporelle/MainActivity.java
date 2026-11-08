package com.example.douanetemporelle;

import android.os.Bundle;

// importation
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // definition ll variables li bch ykhth les valeurs (nom, naissance, destination) w chnwa li bch ykhtar l voyageur  (Motif)
    private EditText edtNom;
    private EditText edtNaissance;
    private EditText edtDestination;
    private RadioGroup rgMotif;
    private Button btnInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //kol variables ykho l valeur 7asb l id edtNom tkhth nom l voyageur w be9i l variables nfs l operation
        edtNom = findViewById(R.id.edt_nom_ml);
        edtNaissance = findViewById(R.id.edt_naissance_ml);
        edtDestination = findViewById(R.id.edt_destination_ml);
        rgMotif = findViewById(R.id.rg_motif_ml);
        btnInspecter = findViewById(R.id.btn_inspecter_ml);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}