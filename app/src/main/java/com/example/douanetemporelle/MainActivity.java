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

        //kol variable y3ml liaison m3a l variable nfso fi xml
        edtNom = findViewById(R.id.edt_nom_ml);
        edtNaissance = findViewById(R.id.edt_naissance_ml);
        edtDestination = findViewById(R.id.edt_destination_ml);
        rgMotif = findViewById(R.id.rg_motif_ml);
        btnInspecter = findViewById(R.id.btn_inspecter_ml);

        btnInspecter.setOnClickListener(v-> {
            //variables ykhtho l valeurs mn variables li liées m3a xml

            String nom = edtNom.getText().toString().trim();
            String naissanceTexte = edtNaissance.getText().toString().trim();
            String destinationTexte = edtDestination.getText().toString().trim();

            //verification ll variables

            if (nom.isEmpty()) {
                edtNom.setError("Veuillez saisir le nom");
                return;
            }

            if (naissanceTexte.isEmpty()) {
                edtNaissance.setError("Veuillez saisir l'année de naissance");
                return;
            }

            if (destinationTexte.isEmpty()) {
                edtDestination.setError("Veuillez saisir l'année de destination");
                return;
            }

            int naissance;
            int destination;

            try {
                naissance = Integer.parseInt(naissanceTexte);
            } catch (NumberFormatException e) {

                edtNaissance.setError("annee invalide");
                return;
            }

            try{
                destination = Integer.parseInt(destinationTexte);
            } catch (NumberFormatException e) {

                edtDestination.setError("annee invalide");
                return;
            }
            // verifiacation : destination lezm tkon > naissance
            if ( destination <= naissance) {

                edtDestination.setError("L'annee doit etre > annee de naissance");

                return;
            }


        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}