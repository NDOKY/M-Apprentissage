package com.example.m_apprentissage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VideoFormationActivity extends AppCompatActivity {
    String coursRecuperer;
    private DatabaseReference mDatabase;
    String videoEnvoye;
    ListView listeVideo;
    BottomNavigationView bottomNavigationView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_formation);
        listeVideo = findViewById(R.id.listeVideo);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        coursRecuperer = getExtra();
        InitListe();
        bottomNavigationView.setSelectedItemId(R.id.formations);
        configureNavigationView();

        listeVideo.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItem = (String) listeVideo.getItemAtPosition(position);

            mDatabase = FirebaseDatabase.getInstance().getReference("VIDEOS").child(coursRecuperer).child(clickedItem);
            mDatabase.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    videoEnvoye = snapshot.getValue(String.class);
                    Intent videoViewIntent = new Intent(getApplicationContext(), VideoViewActivity.class);
                    videoViewIntent.putExtra("VIDEO",videoEnvoye);
                    startActivity(videoViewIntent);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        });



    }

    public String getExtra(){
        return getIntent().getStringExtra("COURS");
    }
    public void InitListe(){
        ArrayList<String> cSharpArrayList = new ArrayList<>();
        cSharpArrayList.add("DataTypes");
        cSharpArrayList.add("HelloWorld");

        ArrayList<String> javaArrayList = new ArrayList<>();
        javaArrayList.add("The JDK");
        javaArrayList.add("Variables");

        ArrayList<String> phpArrayList = new ArrayList<>();
        phpArrayList.add("Cookies");
        phpArrayList.add("DateTime");

        ArrayList<String> comptabiliteArrayList = new ArrayList<>();
        comptabiliteArrayList.add("La TVA");
        comptabiliteArrayList.add("Notion de bilan");
        comptabiliteArrayList.add("Structure du bilan");

        ArrayList<String> droitArrayList = new ArrayList<>();
        droitArrayList.add("Droit privé et droit public");
        droitArrayList.add("Le fait juridique");

        ArrayList<String> statArrayList = new ArrayList<>();
        statArrayList.add("Controle statistique");
        statArrayList.add("Estimation statistique");

        if(coursRecuperer.equals("JAVA")){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, javaArrayList);
            listeVideo.setAdapter(arrayAdapter);
        }
        else if(coursRecuperer.equals("PHP")){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phpArrayList);
            listeVideo.setAdapter(arrayAdapter);
        }
        else if(coursRecuperer.equals("CSharp")){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cSharpArrayList);
            listeVideo.setAdapter(arrayAdapter);
        }

        if(coursRecuperer.equals("Comptabilité")){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, comptabiliteArrayList);
            listeVideo.setAdapter(arrayAdapter);
        }
        else if(coursRecuperer.equals("Statistique")){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, statArrayList);
            listeVideo.setAdapter(arrayAdapter);
        }
        else if(coursRecuperer.equals("Droit")){
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, droitArrayList);
            listeVideo.setAdapter(arrayAdapter);
        }

    }
    public void configureNavigationView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.accueil:
                    startActivity(new Intent(getApplicationContext(), AcceuilActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.formations:
                    startActivity(new Intent(getApplicationContext(), VideoFormationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                case R.id.propos:
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
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(0,0);
                    break;
                   // return true;
                case R.id.deconnexion:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    break;
            }
        });
    }

}