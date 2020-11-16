package com.example.refind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //Creamos los dos objetos de tipo EditText para el correo y la contraseña
    private EditText correo, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "Aplicacion iniciada: Login", Toast.LENGTH_LONG).show();
        this.setTitle("Iniciar sesión");

        //Relacionamos los dos obtejos EditText con el id correspondiente
        correo = (EditText)findViewById(R.id.emailLogin);
        password = (EditText)findViewById(R.id.passLogin);
    }

    /**
     * Metodo asociado al boton iniciarSesion para mandar a la activity MainActivity
     * Falta la comprobacion de que los datos sean correctos
     * @param view
     */
    public void iniciarSesion(View view){
        if(true){
            Intent login_MainActivity = new Intent(this, MainActivity.class);
            startActivity(login_MainActivity);
        }
        else{
            Toast.makeText(this, "Datos introducidos erroneos", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Metodo asociado al boton Registro el cual mandara a la activity Registro
     * @param view
     */
    public void toRegistro(View view){
            Intent login_registro = new Intent(this, Registro.class);
            startActivity(login_registro);
    }
}

