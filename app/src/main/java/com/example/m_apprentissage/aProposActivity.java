package com.example.m_apprentissage;

import androidx.appcompat.app.AppCompatActivity;

import android.net.LinkAddress;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class aProposActivity extends AppCompatActivity {
    Button ccnbButton;
    Button cegepRiviereButton;
    Button cegepGaspesieButton;
    Button educacentreButton;
    Button reseauCegepButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_propos);

        ccnbButton = findViewById(R.id.button_ccnb);
        cegepRiviereButton = findViewById(R.id.button_trois_rivierre);
        cegepGaspesieButton = findViewById(R.id.button_cegep_gaspesie);
        educacentreButton = findViewById(R.id.button_educacentre);
        reseauCegepButton = findViewById(R.id.button_reseau_cegep);

//        public void ccnbButtonClick(LinkAddress link){
//
//        }

    }


}