package com.example.m_apprentissage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AcceuilActivity extends AppCompatActivity {

    Button btnCommencer;
    TextView txtPersonne;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        btnCommencer = findViewById(R.id.commencerbutton);
        txtPersonne = findViewById(R.id.personneTxt);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.accueil);

        //if (ConnexionActivity.)
        txtPersonne.setText(ConnexionActivity.nomPrenom);
        txtPersonne.setText(InscriptionActivity.nomPrenom);

        configureNavigationView();
    }

    public void acceuil_button(View view)
    {
        Intent galleryIntent = new Intent(getApplicationContext(), FormationActivity.class);
        startActivity(galleryIntent);

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