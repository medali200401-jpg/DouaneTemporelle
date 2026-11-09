package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.TextView;

public class VerificationActivity extends AppCompatActivity {
//definition variables
    private TextView txtNom;
    private TextView txtAge;
    private TextView txtMotif;
    private Button btnApprouver;
    private Button btnRefuser;

    // fonction bch n3rfo l differnce entre naissance et destination premier
    private boolean estPremier(int nombre) {

        if (nombre < 2) {
            return false;
        }

        for (int i = 2; i * i <= nombre; i++) {

            if (nombre % i == 0) {
                return false;
            }
        }

        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verification);

        //liaison variables m3a interface xml (VerificationActivity)
        txtNom = findViewById(R.id.txtv_nom_ml);
        txtAge = findViewById(R.id.txtv_age_ml);
        txtMotif = findViewById(R.id.txtv_motif_ml);
        btnApprouver = findViewById(R.id.btnv_approuver_ml);
        btnRefuser = findViewById(R.id.btnv_refuser_ml);






        //recuperer variables li tb3tho mn MainActivity
        String nom = getIntent().getStringExtra( MainActivity.cle(MainActivity.MATRICULE,"NOM_VOYAGEUR"));
        int naissance = getIntent().getIntExtra( MainActivity.cle(MainActivity.MATRICULE,"ANNEE_NAISSANCE"),0);
        int destination = getIntent().getIntExtra(MainActivity.cle(MainActivity.MATRICULE, "ANNEE_DESTINATION"),0);
        String motif = getIntent().getStringExtra(
                MainActivity.cle(MainActivity.MATRICULE, "MOTIF")
        );
        int ageTemporel = destination - naissance;

        //if modifer du passe et nombre de la difference est premier disabled l approuver
        if (motif.equals("Modification du passe") && estPremier(ageTemporel)) {
            btnApprouver.setEnabled(false);
        }

        btnApprouver.setOnClickListener(v -> {

            //cree intent thz ll ResultActivity
            Intent intent = new Intent(
                    VerificationActivity.this,
                    ResultActivity.class
            );

            //le resultat final de voyageur y3ni approuver, m3a nom
            intent.putExtra(
                    MainActivity.cle(MainActivity.MATRICULE, "VERDICT"),
                    true
            );


            intent.putExtra(
                    MainActivity.cle(MainActivity.MATRICULE, "NOM_VOYAGEUR"),
                    nom
            );
            //tbdl ll resultActivity m3a resultat true w nom ll approuver
            startActivity(intent);

        });

        btnRefuser.setOnClickListener(v -> {

            Intent intent =new Intent(VerificationActivity.this, ResultActivity.class);

            intent.putExtra( MainActivity.cle(MainActivity.MATRICULE, "VERDICT"), false);

            intent.putExtra( MainActivity.cle(MainActivity.MATRICULE,"NOM_VOYAGEUR"), nom);

            //tbdl ll ResultActivity m3a resultat false refuser
            startActivity(intent);
        });

        // aafichage valeurs fi interface VerificationActivity
        txtAge.setText("Age temporel : " + ageTemporel);
        txtNom.setText("Nom : " + nom);
        txtMotif.setText("Motif : " + motif);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lin_rslt_ml), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}