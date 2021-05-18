package com.example.m_apprentissage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    DatabaseReference mDatabase;
    BottomNavigationView bottomNavigationView;
    EditText prenom;
    EditText nom;
    EditText titre;
    EditText etablissement;
    EditText email;
    EditText password;
    Button modifier;
    FirebaseUser firebaseUser;
    User user;
    String nomUser;
    static String autreNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        email = findViewById(R.id.editTextCourriel);
        password = findViewById(R.id.editTextPass);
        modifier = findViewById(R.id.modifButton);
        nom = findViewById(R.id.editTextNom);
        titre = findViewById(R.id.editTextTitle);
        etablissement = findViewById(R.id.editTextEtab);
        prenom = findViewById(R.id.editTextPre);
        nomUser = getIntent().getStringExtra("nomUser");
        //mDatabase = FirebaseDatabase.getInstance().getReference("User").child(nomUser);
        if(nomUser != null){
            if(nomUser.equals("connexion")){
                mDatabase = FirebaseDatabase.getInstance().getReference("User").child(ConnexionActivity.nomPrenom);
            }
            else if(nomUser.equals("inscription")){
                mDatabase = FirebaseDatabase.getInstance().getReference("User").child(InscriptionActivity.nomPrenom);
            }
        }
        else{
            mDatabase = FirebaseDatabase.getInstance().getReference("User").child(autreNom);
        }

        bottomNavigationView.setSelectedItemId(R.id.profile);
        configureNavigationView();




        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        email.setText(firebaseUser.getEmail());


        ValueEventListener userListener = new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user = snapshot.getValue(User.class);
                Toast.makeText(getApplicationContext(), "Value are getting read",Toast.LENGTH_SHORT).show();
                nom.setText(user.getNomUser());
                prenom.setText(user.getPrenomUser());
                titre.setText(user.getTitreUser());
                etablissement.setText(user.getEtablissementUser());
                autreNom = user.getNomUser()+" "+user.getPrenomUser();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.toException().toString(),Toast.LENGTH_SHORT).show();
            }
        };
        mDatabase.addValueEventListener(userListener);






    }

    public void updateProfile(View view){
        firebaseUser.updateEmail(email.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Email successfully changed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "An error occurred",Toast.LENGTH_SHORT).show();
                }
            }
        });
        firebaseUser.updatePassword(password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener(){

            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Password successfully changed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "An error occurred",Toast.LENGTH_SHORT).show();
                }
            }
        });
        user = new User(prenom.getText().toString().trim(),nom.getText().toString().trim(),titre.getText().toString().trim(),etablissement.getText().toString().trim(),email.getText().toString().trim(),password.getText().toString().trim());
        mDatabase.setValue(user);


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
                    startActivity(new Intent(getApplicationContext(), FormationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;

                case R.id.propos:
                    startActivity(new Intent(getApplicationContext(), aProposActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                    return true;
                /*case R.id.profile:
                    Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                    profileIntent.putExtra("nomUser",nomUser);
                    startActivity(profileIntent);
                    overridePendingTransition(0,0);
                    finish();
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
                    startActivity(new Intent(getApplicationContext(), FormationActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.propos:
                    startActivity(new Intent(getApplicationContext(), aProposActivity.class));
                    overridePendingTransition(0,0);
                    break;
                /*case R.id.profile:
                    Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                    profileIntent.putExtra("nomUser",nomUser);
                    startActivity(profileIntent);
                    overridePendingTransition(0,0);
                    finish();
                    break;*/
                case R.id.deconnexion:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    break;
            }
        });
    }
}