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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    boolean exist = false;
    User user;

    private FirebaseDatabase mDatabase;
    DatabaseReference ref;
    private FirebaseAuth mAuth;
    Toast message;// = Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);


    public MainActivity() {
        message = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        message = Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);
        prenom = findViewById(R.id.editTextTextPrenom);
        nom = findViewById(R.id.editTextTextNom);
        titre = findViewById(R.id.editTextTextTitre);
        etablissement = findViewById(R.id.editTextTextEtablissement);
        email = findViewById(R.id.editTextEmailAddress);
        password = findViewById(R.id.editTextPassword);
        btnConnexion = findViewById(R.id.buttonConnexion);

        btnConnexion.setOnClickListener(view -> {
            //exist = false;
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
                user = new User(strPrenom, strNom, strTitre, strEtablissement, strEmail, strPassword);


                ref = FirebaseDatabase.getInstance().getReference("User");
                createAccount(strEmail, strPassword);

            }
        });

    }
    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()){
                Toast.makeText(getApplicationContext(), "User successfully create",Toast.LENGTH_SHORT).show();
                ref.child(strNom + " " + strPrenom).setValue(user);
                Intent in = new Intent(getApplicationContext(), videoGalleryActivity.class);
                startActivity(in);
            }
            else {
                Toast.makeText(getApplicationContext(), "Authentication failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

}

