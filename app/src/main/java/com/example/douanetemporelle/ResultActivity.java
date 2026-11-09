package com.example.douanetemporelle;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        txtMessage = findViewById(R.id.txt_message_ml);
        boolean approuve = getIntent().getBooleanExtra( MainActivity.cle(MainActivity.MATRICULE, "VERDICT"), false);

        String nom = getIntent().getStringExtra( MainActivity.cle(MainActivity.MATRICULE, "NOM_VOYAGEUR"));

        if(approuve){
            txtMessage.setText("Bon voyage " + nom);
        } else {
            txtMessage.setText(nom + " est un etat d'arrestation temporelle");
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}