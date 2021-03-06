package com.example.m_apprentissage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class aProposActivity extends AppCompatActivity {
    Button ccnbButton;
    Button cegepRiviereButton;
    Button cegepGaspesieButton;
    Button educacentreButton;
    Button reseauCegepButton;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_propos);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ccnbButton = findViewById(R.id.button_ccnb);
        cegepRiviereButton = findViewById(R.id.button_trois_rivierre);
        cegepGaspesieButton = findViewById(R.id.button_cegep_gaspesie);
        educacentreButton = findViewById(R.id.button_educacentre);
        reseauCegepButton = findViewById(R.id.button_reseau_cegep);
        bottomNavigationView.setSelectedItemId(R.id.propos);

        configureNavigationView();
//        public void ccnbButtonClick(LinkAddress link){
//
//        }

    }
    public void configureNavigationView(){

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.accueil:
                    startActivity(new Intent(getApplicationContext(), AcceuilActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.formations:
                    //bottomNavigationView.setSelectedItemId(R.id.formations);
                    startActivity(new Intent(getApplicationContext(), FormationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.propos:
                    //bottomNavigationView.setSelectedItemId(R.id.propos);
                    startActivity(new Intent(getApplicationContext(), aProposActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.deconnexion:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                    return true;
            }
            return false;
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(item -> {
            switch (item.getItemId()){
                case R.id.accueil:
                    bottomNavigationView.setSelectedItemId(R.id.accueil);
                    startActivity(new Intent(getApplicationContext(), AcceuilActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.formations:
                    bottomNavigationView.setSelectedItemId(R.id.formations);
                    startActivity(new Intent(getApplicationContext(), FormationActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.profile:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.deconnexion:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0, 0);
                    break;
            }
        });
    }

}