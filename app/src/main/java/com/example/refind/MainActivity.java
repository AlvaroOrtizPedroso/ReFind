package com.example.refind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "asdasd", Toast.LENGTH_LONG).show();
        init();
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

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));
        elements.add(new ListElement("#775447", "Pedro","Espanita", "Activo"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}