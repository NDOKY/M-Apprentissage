package com.example.m_apprentissage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_login);

    }

    public void openSignIn(View view){
        Intent signInIntent = new Intent(this, InscriptionActivity.class);
        startActivity(signInIntent);
    }
    public void openConnexion(View view){
        Intent connexionIntent = new Intent(this, ConnexionActivity.class);
        startActivity(connexionIntent);
    }
}