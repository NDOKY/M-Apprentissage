package com.example.m_apprentissage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ConnexionActivity extends AppCompatActivity {

    EditText mEmail, mPassword,mNomPrenom;
    Button mConnexion;
    FirebaseAuth firebaseAuth;
    static String nomPrenom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        mEmail = findViewById(R.id.editTextEmailAddress);
        mPassword = findViewById(R.id.editTextPassword);
        mConnexion = findViewById(R.id.buttonConnexion);
        mNomPrenom = findViewById(R.id.editTextNomPrenom);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void ConnexionButton(View view){
        String email = mEmail.getText().toString().trim();
        String passWord = mPassword.getText().toString().trim();
        nomPrenom = mNomPrenom.getText().toString().trim();

        firebaseAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ConnexionActivity.this, "User successful login", Toast.LENGTH_SHORT).show();
                    Intent accueilIntent = new Intent(getApplicationContext(), AcceuilActivity.class);
                    accueilIntent.putExtra("activity", "connexion");
                    startActivity(accueilIntent);
                    finish();
                }
                else{
                    Toast.makeText(ConnexionActivity.this, "Un probleme est survenu lors de votre connexion", Toast.LENGTH_LONG).show();

                }

            }
        });

        if(!email.isEmpty() && !passWord.isEmpty()){
            mEmail.setText("");
            mPassword.setText("");
        }
    }
}