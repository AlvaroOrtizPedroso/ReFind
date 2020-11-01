package com.example.refind;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Perfil extends AppCompatActivity {



    // Metodos y variables para dar permisos y acceder a la galeria
    ImageView fotoUsuario;
    Button cambiarFoto;

    private static final int REQUEST_PERMISSION_CODE = 100;
    private static final int REQUEST_IMAGE_GALLERY = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toast.makeText(this, "Aplicacion iniciada: Perfil", Toast.LENGTH_LONG).show();
        fotoUsuario = findViewById(R.id.fotoUsuario);
        cambiarFoto = findViewById(R.id.cambiarFoto);

        cambiarFoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ActivityCompat.checkSelfPermission(Perfil.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        openGallery();
                    }else{
                        ActivityCompat.requestPermissions(Perfil.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_PERMISSION_CODE);
                    }
                }else{
                    openGallery();
                }
            }
        });
    }

    // METODOS PARA EL MENU DESPLEGABLE

    /**
     * Metoto para mostrar u ocultar el menu
     * Debemos crear un metodo con este nombre exactamente al cual le pasamos un parametro de tipo MenuItem
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu){
        //Carpeta res - menu - overflow y pasamos el objeto menu
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    /**
     * Metodo para indicar a cual en cual de las opciones se hizo clic
     * Debemos crear un metodo con este nombre exactamente al cual le pasamos un parametro de tipo MenuItem
     * @param item
     * @return
     */
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
    }







    // METODOS PARA OBTENER LOS PERMISOS Y ADQUIRIR UNA FOTO DE LA GALERIA
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_GALLERY){
            if(resultCode == Activity.RESULT_OK && data!=null){
                Uri photo = data.getData();
                // nombre que hace referencia a la ImagenViewq
                fotoUsuario.setImageURI(photo);
            }else{
                Log.i("TAG", "Resultado: "+ resultCode);
                Toast.makeText(this, "No se escogio imagen de la galeria", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERMISSION_CODE){
            if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openGallery();
            }else{
                Toast.makeText(this, "Necesitas activar los permisos", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void openGallery(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_GALLERY);
    }
}