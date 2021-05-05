package com.example.m_apprentissage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListeVideoActivity extends AppCompatActivity {
    String coursRecuperer;
    private DatabaseReference mDatabase;
    String videoEnvoye;
    ListView listeVideo;
    //String clickedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_video);


        listeVideo = findViewById(R.id.listeVideo);
        coursRecuperer = getExtra();
        //Toast.makeText(getApplicationContext(),coursRecuperer, Toast.LENGTH_SHORT).show();
        InitListe();


        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        //listeVideo.setAdapter(arrayAdapter);

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
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("video01");
        arrayList.add("video02");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listeVideo.setAdapter(arrayAdapter);
    }
}