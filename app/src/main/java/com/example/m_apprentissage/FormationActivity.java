package com.example.m_apprentissage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FormationActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView listProgrammation;
    ListView listAdministration;
    ArrayList<String> arrayListProg;
    ArrayList<String> arrayListAdministration;
    static String nomUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);
        listProgrammation = findViewById(R.id.listProgrammation);
        listAdministration = findViewById(R.id.listAdministration);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.formations);
        remplissageListe();
        nomUser = getIntent().getStringExtra("nomUser");
        configureNavigationView();

        ArrayAdapter<String> arrayAdapterProg = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListProg);
        listProgrammation.setAdapter(arrayAdapterProg);

        ArrayAdapter<String> arrayAdapterAdministration = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListAdministration);
        listAdministration.setAdapter(arrayAdapterAdministration);

        listProgrammation.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItem = (String) listProgrammation.getItemAtPosition(position);
            Intent listeVideoIntent = new Intent(getApplicationContext(), VideoFormationActivity.class);
            listeVideoIntent.putExtra("COURS",clickedItem);
            startActivity(listeVideoIntent);
        });

        listAdministration.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItem = (String) listAdministration.getItemAtPosition(position);
            Intent listeVideoIntent = new Intent(getApplicationContext(), VideoFormationActivity.class);
            listeVideoIntent.putExtra("COURS",clickedItem);
            startActivity(listeVideoIntent);
        });

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
                    startActivity(new Intent(getApplicationContext(), FormationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;

                case R.id.propos:
                    startActivity(new Intent(getApplicationContext(), aProposActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.profile:
                    Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                    profileIntent.putExtra("nomUser",nomUser);
                    startActivity(profileIntent);
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.deconnexion:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
            }
            return false;
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(item -> {
            switch (item.getItemId()){
                case R.id.accueil:
                    startActivity(new Intent(getApplicationContext(), AcceuilActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.formations:
                    startActivity(new Intent(getApplicationContext(), FormationActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.propos:
                    startActivity(new Intent(getApplicationContext(), aProposActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.profile:
                    Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                    profileIntent.putExtra("nomUser",nomUser);
                    startActivity(profileIntent);
                    overridePendingTransition(0,0);
                    //finish();
                    break;
                case R.id.deconnexion:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    break;
            }
        });
    }

    public void remplissageListe(){
        arrayListProg = new ArrayList<>();
        arrayListProg.add("JAVA");
        arrayListProg.add("PHP");
        arrayListProg.add("CSharp");

        arrayListAdministration = new ArrayList<>();
        arrayListAdministration.add("Comptabilit??");
        arrayListAdministration.add("Statistique");
        arrayListAdministration.add("Droit");
    }

}

