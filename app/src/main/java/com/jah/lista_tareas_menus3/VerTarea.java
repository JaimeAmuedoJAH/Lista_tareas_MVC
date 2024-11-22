package com.jah.lista_tareas_menus3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class VerTarea extends AppCompatActivity {

    //Clase en la que se muestra la informacion de la tarjeta marcada. No se puede modificar.

    TextView lblInfoNombre, lblInfoFecha, lblInfoHora, lblInfoDescripcion, lblInfoCategoria;
    ImageView imgvInfoImagen;
    Button btnVolver, btnEditar;
    Intent recibirDatos;
    int posicion;
    Tarea tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_tarea);
        initComponents();

        btnVolver.setOnClickListener(view -> finish());
        btnEditar.setOnClickListener(view -> editarTarea());
    }
    //Si pulsamos el boton editar, cambiamos a otra ventana para poder editar la tarea si lo deseamos.
    private void editarTarea() {
        Intent editarTarea = new Intent(getApplicationContext(), EditarTarea.class);
        editarTarea.putExtra("posicion", posicion);
        startActivity(editarTarea);
        finish();
    }

    private void initComponents() {
        lblInfoHora = findViewById(R.id.lblInfoHora);
        lblInfoNombre = findViewById(R.id.lblInfoNombre);
        lblInfoFecha = findViewById(R.id.lblInfoFecha);
        lblInfoDescripcion = findViewById(R.id.lblInfoDescripcion);
        lblInfoCategoria = findViewById(R.id.lblInfoCategoria);
        imgvInfoImagen = findViewById(R.id.imgvInfoImagen);
        btnVolver = findViewById(R.id.btnVolver);
        btnEditar = findViewById(R.id.btnEditar);
        //Recibimos los datos de la clase anterior en este caso un int con la posicion.
        recibirDatos = getIntent();
        posicion = recibirDatos.getIntExtra("posicion", 0);
        tarea = GestionTarea.getArrTarea().get(posicion);
        //Asignamos los datos que hemos recogido de nuestra tarea del array de tareas.
        lblInfoNombre.setText(tarea.getNombre());
        lblInfoFecha.setText(tarea.getFecha());
        lblInfoHora.setText(tarea.getHora());
        lblInfoDescripcion.setText(tarea.getDescripcion());
        lblInfoCategoria.setText(tarea.getCategoria());
        imgvInfoImagen.setImageResource(tarea.getImagen());
    }
}