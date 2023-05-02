package com.example.loginpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class kayit_ol extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText kayitEmail,kayitSifre;
    private Button kayitButton;
    private TextView giriseAtlama;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit_ol);
        auth = FirebaseAuth.getInstance();
        kayitEmail = findViewById(R.id.kayit_email);
        kayitSifre = findViewById(R.id.kayit_sifre);
        kayitButton= findViewById(R.id.kayit_button);
        giriseAtlama= findViewById(R.id.login_giris_ekrani);

        kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = kayitEmail.getText().toString().trim();
                String pass = kayitSifre.getText().toString().trim();

                if(user.isEmpty()){
                    kayitEmail.setError("Email Boş Olamaz");
                }
                if(pass.isEmpty()){
                    kayitSifre.setError("Şifre Boş Olamaz");
                }else{
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(kayit_ol.this,"Kayıt Başarılı",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(kayit_ol.this,giris_yap.class));
                            }else{
                                Toast.makeText(kayit_ol.this,"Kayıt Başarısız"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        giriseAtlama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kayit_ol.this,giris_yap.class));
            }
        });

    }



}