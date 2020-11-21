package com.example.refind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Clase que en la que se muestran las imagenes en pantalla completa
 */
public class Imagen_Grid_Full extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen__grid__full);
        //Obtenemos el id imagenView_grid de la activity_imagen_grid_full
        imageView = (ImageView) findViewById(R.id.imagenView_grid);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Tamaño completo imagen");

        Intent i = getIntent();
        //Le pasamos el id de enviarImagenFull que se encuentra en Perfil
        int position = i.getExtras().getInt("id");
        ImagenAdapter imagenAdapter = new ImagenAdapter(this);

        imageView.setImageResource(imagenAdapter.imagenArray[position]);
    }
}