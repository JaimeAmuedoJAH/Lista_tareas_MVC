package com.jah.lista_tareas_menus3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar mtbMenu;
    RecyclerView rvTareas;
    AdaptadorTareas adaptadorTareas;
    LinearLayoutManager disposicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initComponents();
        //Para establecer la barra donde se encuentra el menu.
        setSupportActionBar(mtbMenu);
    }


    //Cuando volvemos de otra activity se ejecuta este metodo y no el oncrete. Para esto no debes usar un intent en la otra clase solamente finish().
   @Override
    protected void onPostResume() {
        super.onPostResume();
        //Actualizamos el adaptador.
        adaptadorTareas = new AdaptadorTareas(GestionTarea.getArrTarea());
        rvTareas.setAdapter(adaptadorTareas);
        adaptadorTareas.notifyDataSetChanged();
    }

    //Hacemos que se infle el menu para hacerlo visible.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    //Recogemos la opcion que hemos marcado dentro del menu.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_Nueva){
            Intent nuevaTarea = new Intent(getApplicationContext(), AnhadirTarea.class);
            startActivity(nuevaTarea);
        }else if(item.getItemId() == R.id.item_categoria){
            GestionTarea.ordenarPorCategoria();
            adaptadorTareas = new AdaptadorTareas(GestionTarea.getArrTarea());
            rvTareas.setAdapter(adaptadorTareas);
        }else if(item.getItemId() == R.id.item_fecha){
            GestionTarea.ordenarPorFecha();
            adaptadorTareas = new AdaptadorTareas(GestionTarea.getArrTarea());
            rvTareas.setAdapter(adaptadorTareas);
        }else if(item.getItemId() == R.id.item_salir){
            finishAffinity();
        }
        return false;
    }

    private void initComponents() {
        rvTareas = findViewById(R.id.rvTareas);
        mtbMenu = findViewById(R.id.mtbMenu);
        disposicion = new LinearLayoutManager(getApplicationContext());
        rvTareas.setLayoutManager(disposicion);
        adaptadorTareas = new AdaptadorTareas(GestionTarea.cargarDatos());
        rvTareas.setAdapter(adaptadorTareas);
    }

}