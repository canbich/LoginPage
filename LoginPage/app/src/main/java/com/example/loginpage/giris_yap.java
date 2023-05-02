package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class giris_yap extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText girisEmail,girisSifre;
    private TextView kayitatlamatext;
    private Button girisButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris_yap);
        auth= FirebaseAuth.getInstance();
        girisEmail=findViewById(R.id.giris_yap_email);
        girisSifre=findViewById(R.id.giris_yap_sifre);
        girisButton=findViewById(R.id.giris_button);
        kayitatlamatext=findViewById(R.id.kayita_atlama);

        girisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = girisEmail.getText().toString();
                String password= girisSifre.getText().toString();

                if(!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!password.isEmpty()){
                        auth.signInWithEmailAndPassword(email,password)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(giris_yap.this,"Giriş Yapıldı",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(giris_yap.this,MainActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(giris_yap.this,"Giriş Yapılamadı",Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }else{
                        girisSifre.setError("Şifre Boş Olamaz");

                    }

                } else if (email.isEmpty()) {
                    girisEmail.setError("Email Boş Olamaz");

                }else{
                    girisEmail.setError("Lütfen Geçerli Email Giriniz.");
                }
            }
        });

        kayitatlamatext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(giris_yap.this,kayit_ol.class));
            }
        });
    }


}