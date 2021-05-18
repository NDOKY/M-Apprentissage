package com.example.m_apprentissage;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InscriptionActivity extends AppCompatActivity {
    private static final String TAG = "Vérification";
    EditText prenom, nom, titre, etablissement, email, password;
    TextView seConnecter;
    String strPrenom, strNom, strTitre, strEtablissement, strEmail, strPassword;
    Button btnConnexion;
    boolean exist = false;
    User user;
    private FirebaseDatabase mDatabase;
    DatabaseReference ref;
    private FirebaseAuth mAuth;
    FirebaseAuth firebaseAuth;
    Toast message;// = Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);
    static String nomPrenom;

    public InscriptionActivity() {
        message = null;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
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


                prenom.setText("");
                nom.setText("");
                titre.setText("");
                etablissement.setText("");
                email.setText("");
                password.setText("");
            }
        });
    }
    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()){

                mAuth.getCurrentUser().sendEmailVerification()
                        .addOnCompleteListener(this, new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(InscriptionActivity.this,
                                            "Verification email sent to " + mAuth.getCurrentUser().getEmail(),
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    Log.e(TAG, "sendEmailVerification", task.getException());
                                    Toast.makeText(InscriptionActivity.this,
                                            "Une erreur est survenue",
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                Toast.makeText(getApplicationContext(), "User successfully create",Toast.LENGTH_SHORT).show();
                nomPrenom = strNom + " " + strPrenom;
                ref.child(nomPrenom).setValue(user);
                Intent galleryIntent = new Intent(getApplicationContext(), FormationActivity.class);
                galleryIntent.putExtra("nomUser", "inscription");
                startActivity(galleryIntent);
                finish();
            }
            /*else {
                //Toast.makeText(getApplicationContext(), "Entr",Toast.LENGTH_SHORT).show();
            }*/
        });
    }
}
