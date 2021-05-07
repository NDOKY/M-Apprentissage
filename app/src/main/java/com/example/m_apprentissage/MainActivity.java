package com.example.m_apprentissage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    EditText prenom, nom, titre, etablissement, email, password;
    TextView seConnecter;
    String strPrenom, strNom, strTitre, strEtablissement, strEmail, strPassword;
    Button btnConnexion;
    private int compteur;
    String utilisateurExistant;

    private final FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prenom = (EditText) findViewById(R.id.editTextTextPrenom);
        nom = (EditText) findViewById(R.id.editTextTextNom);
        titre = (EditText) findViewById(R.id.editTextTextTitre);
        etablissement = (EditText) findViewById(R.id.editTextTextEtablissement);
        email = (EditText) findViewById(R.id.editTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextPassword);
        btnConnexion = (Button) findViewById(R.id.buttonConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strPrenom = prenom.getText().toString();
                strNom = nom.getText().toString();
                strTitre = titre.getText().toString();
                strEtablissement = etablissement.getText().toString();
                strEmail = email.getText().toString();
                strPassword = password.getText().toString();


                if (strPrenom.equalsIgnoreCase(""))
                {
                    prenom.setError("Veuillez entrer le prenom");//it gives user to info message //use any one //
                }
                else if(strNom.equalsIgnoreCase("")){
                    nom.setError("Veuillez entrer le nom");//it gives user to info message //use any one //
                }
                else if(strTitre.equalsIgnoreCase("")){
                    titre.setError("Veuillez entrer le titre");//it gives user to info message //use any one //
                }
                else if(strEtablissement.equalsIgnoreCase("")){
                    etablissement.setError("Veuillez entrer l'établissement");//it gives user to info message //use any one //
                }
                else if(strEmail.equalsIgnoreCase("")){
                    email.setError("please enter l'email");//it gives user to info message //use any one //
                }
                else if(strPassword.equalsIgnoreCase("")){
                    password.setError("please enter le password");//it gives user to info message //use any one //
                }
                else {
                    User user = new User(strPrenom, strNom, strTitre, strEtablissement, strEmail, strPassword);

                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    ref.child("User").child("courrielUser").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                // use "username" already exists
                                Toast.makeText(MainActivity.this, "Désolé un compte existe déjà avec l'adresse email entré!", Toast.LENGTH_LONG).show();
                            } else {

                                compteur += 1;

                                Intent in = new Intent(getApplicationContext(), videoGalleryActivity.class);
                                startActivity(in);

                                mDatabaseReference = mDatabase.getReference().child("User");
                                String userId = "";
                                mDatabaseReference.child(userId).setValue(user);

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

//                    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
//                    DatabaseReference uidRef = rootRef.child("User").child(uid);
//                    ValueEventListener eventListener = new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            if(!dataSnapshot.exists()) {
//                                compteur += 1;
//
//                                Intent in = new Intent(getApplicationContext(), videoGalleryActivity.class);
//                                startActivity(in);
//
//                                mDatabaseReference = mDatabase.getReference().child("User");
//
//                                mDatabaseReference.setValue(user);
//                            }
//                            else
//                            {
//                                Toast.makeText(MainActivity.this, "Désolé un compte existe déjà avec l'adresse email entré!", Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {}
//                    };
//                    uidRef.addListenerForSingleValueEvent(eventListener);

//                    Query mGetReference = null;
//                    mGetReference.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                            if (dataSnapshot.exists()){
//                                HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();
//
//                                for (String key : dataMap.keySet()){
//
//                                    Object data = dataMap.get(key);
//
//                                    try {
//                                        HashMap<String, Object> userData = (HashMap<String, Object>) data;
//
//                                        User mUser = new User((String) userData.get("courrielUser"));
//                                        //addTextToView(mUser.getName() + " - " + Integer.toString(mUser.getAge()));
//                                        utilisateurExistant = mUser.getCourrielUser();
//
//                                        if (utilisateurExistant != strEmail) {
//                                            compteur += 1;
//
//                                            Intent in = new Intent(getApplicationContext(), videoGalleryActivity.class);
//                                            startActivity(in);
//
//                                            mDatabaseReference = mDatabase.getReference().child("User");
//                                            String userId = "";
//                                            mDatabaseReference.child(userId).setValue(user);
//                                        }
//                                        else
//                                        {
//                                            Toast.makeText(MainActivity.this, "Désolé un compte existe déjà avec l'adresse email entré!", Toast.LENGTH_LONG).show();
//
//                                        }
//                                    }catch (ClassCastException cce){
//
//                                        // If the object can’t be casted into HashMap, it means that it is of type String.
//
//                                        try{
//
//                                            String mString = String.valueOf(dataMap.get(key));
//                                            //addTextToView(mString);
//
//                                        }catch (ClassCastException cce2){
//
//                                        }
//                                    }
//
//                                }
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                        }
//                    });
                }
            }
        });

    }
}

