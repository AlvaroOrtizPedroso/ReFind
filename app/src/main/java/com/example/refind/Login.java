package com.example.refind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "Aplicacion iniciada: Login", Toast.LENGTH_LONG).show();
        this.setTitle("Iniciar sesión");
    }
}

