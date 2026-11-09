package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;


public class ResultActivity extends AppCompatActivity {
    private TextView txtMessage;

    private Button btnNouveau;

    private LinearLayout layoutrslt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        layoutrslt = findViewById(R.id.lin_rslt_ml);

        txtMessage = findViewById(R.id.txt_message_ml);
        btnNouveau = findViewById(R.id.btn_nouveau_ml);
        boolean approuver = getIntent().getBooleanExtra( MainActivity.cle(MainActivity.MATRICULE, "VERDICT"), false);

        String nom = getIntent().getStringExtra( MainActivity.cle(MainActivity.MATRICULE, "NOM_VOYAGEUR"));



        if(approuver){
            txtMessage.setText("Bon voyage " + nom);
            txtMessage.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
            layoutrslt.setBackgroundColor(Color.GREEN);
        } else {
            txtMessage.setText(nom + " est un etat d'arrestation temporelle");
            txtMessage.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            layoutrslt.setBackgroundColor(Color.RED);

        }

        btnNouveau.setOnClickListener(v -> {

            //retour ll interface MainActivity w fermer ll activity en cours
            Intent intent = new Intent(

                    ResultActivity.this, MainActivity.class
            );

            //fermer ll activity li konna fiha
            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );

            //nbdlo ll MainActivity
            startActivity(intent);

            //fermer ll activity en cours (ResultActivity)
            finish();


        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lin_rslt_ml), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}