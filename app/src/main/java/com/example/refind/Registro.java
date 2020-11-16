package com.example.refind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toast.makeText(this, "Aplicacion iniciada: Registro", Toast.LENGTH_LONG).show();
    }

    /**
     * Metodo asociado al boton iniciarSesion para mandar a la activity login
     * @param view
     */
    public void iniciarSesion(View view){
        Intent registro_login = new Intent(this, Login.class);
        startActivity(registro_login);
    }

    /**
     * Metodo asociado al boton registro
     *  //Falta por hacer
     *      -comprobar los datos que sean correcto
     *      -Insertar los datos en la base de datos
     *      -Logear directamente
     * @param view
     */
    public void registrar(View view){
        if(true){
            Intent registro_MainActivity = new Intent(this, MainActivity.class);
            startActivity(registro_MainActivity);
        }
        else{
            Toast.makeText(this, "Datos introducidos erroneos", Toast.LENGTH_LONG).show();
        }
    }





    /**
     * Metoto para mostrar u ocultar el menu
     * Debemos crear un metodo con este nombre exactamente al cual le pasamos un parametro de tipo MenuItem
     * @param menu
     * @return

    public boolean onCreateOptionsMenu(Menu menu){
        //Carpeta res - menu - overflow y pasamos el objeto menu
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }


     * Metodo para indicar a cual en cual de las opciones se hizo clic
     * Debemos crear un metodo con este nombre exactamente al cual le pasamos un parametro de tipo MenuItem
     * @param item
     * @return

    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();

        // Id de cada opcion del menu
        if(id == R.id.menuPrincipal){
            Toast.makeText(this, "Menu Principal", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.menuRegistro){
            Toast.makeText(this, "Registro", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.menuIniciarSesion){
            Toast.makeText(this, "Iniciar Sesion", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }*/
}