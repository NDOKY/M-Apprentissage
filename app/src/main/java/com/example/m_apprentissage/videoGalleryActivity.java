package com.example.m_apprentissage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class videoGalleryActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView listProgrammation;
    ListView listAdministration;
    ArrayList<String> arrayListProg;
    ArrayList<String> arrayListAdministration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videogallery);
        listProgrammation = findViewById(R.id.listProgrammation);
        listAdministration = findViewById(R.id.listAdministration);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.formations);
        configureNavigationView();
        remplissageListe();


        ArrayAdapter<String> arrayAdapterProg = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListProg);
        listProgrammation.setAdapter(arrayAdapterProg);

        ArrayAdapter<String> arrayAdapterAdministration = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListAdministration);
        listAdministration.setAdapter(arrayAdapterAdministration);

        listProgrammation.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItem = (String) listProgrammation.getItemAtPosition(position);
            Intent listeVideoIntent = new Intent(getApplicationContext(), ListeVideoActivity.class);
            listeVideoIntent.putExtra("COURS",clickedItem);
            startActivity(listeVideoIntent);
        });

        configureNavigationView();
    }

    public void configureNavigationView(){

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.accueil:
                    startActivity(new Intent(getApplicationContext(), ConnexionActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.formations:
                    startActivity(new Intent(getApplicationContext(), videoGalleryActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;

                case R.id.propos:
                    startActivity(new Intent(getApplicationContext(), aProposActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                /*case R.id.profile:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    return true;*/
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
                    startActivity(new Intent(getApplicationContext(), ConnexionActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.formations:
                    startActivity(new Intent(getApplicationContext(), videoGalleryActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.propos:
                    startActivity(new Intent(getApplicationContext(), aProposActivity.class));
                    overridePendingTransition(0,0);
                    break;
                /*case R.id.profile:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    return true;*/
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
        arrayListAdministration.add("Comptabilité");
        arrayListAdministration.add("Statistique");
        arrayListAdministration.add("Droit");
    }

}

