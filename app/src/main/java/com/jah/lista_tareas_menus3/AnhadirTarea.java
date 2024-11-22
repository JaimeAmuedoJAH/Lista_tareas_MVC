package com.jah.lista_tareas_menus3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AnhadirTarea extends AppCompatActivity {

    TextView txtNuevaNombre, txtNuevaFecha, txtNuevaHora, txtNuevaDescripcion;
    Button btnAnhadir;
    RadioGroup rgNuevaCategoria1, rgNuevaCategoria2;
    RadioButton rbNuevaFamilia, rbNuevaAmigos, rbNuevaOcio, rbNuevaDeporte, rbNuevaEstudios, rbNuevaTrabajo;
    Tarea tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_anhadir_tarea);
        initComponents();

        btnAnhadir.setOnClickListener(view -> addTarea());
        rgNuevaCategoria1.setOnCheckedChangeListener((radioGroup, i) -> desmarcar(2));
        rgNuevaCategoria2.setOnCheckedChangeListener((radioGroup, i) -> desmarcar(1));
    }
    //Si marcamos una opcion de uno de los radiogroups opuestos se desmarcan los del otro.
    private void desmarcar(int i) {
        if(i == 1){
            rbNuevaFamilia.setChecked(false);
            rbNuevaAmigos.setChecked(false);
            rbNuevaOcio.setChecked(false);
        }else {
            rbNuevaDeporte.setChecked(false);
            rbNuevaEstudios.setChecked(false);
            rbNuevaTrabajo.setChecked(false);
        }
    }
    //Añadimos la tarea nueva a nuestra lista.
    private void addTarea() {
        String nombre = txtNuevaNombre.getText().toString();
        String fecha = txtNuevaFecha.getText().toString();
        String hora = txtNuevaHora.getText().toString();
        String descripcion = txtNuevaDescripcion.getText().toString();
        String categoria = obtenerCategoria();
        int imagen = obtenerImagen();

        tarea = new Tarea(nombre, fecha, hora, descripcion, categoria, imagen);
        GestionTarea.anhadirTarea(tarea);
        finish();
    }
    
    private String obtenerCategoria() {
        String categoria = "";
        if(rbNuevaFamilia.isChecked()){
            categoria = "Familia";
        }else if(rbNuevaAmigos.isChecked()){
            categoria = "Amigos";
        }else if(rbNuevaOcio.isChecked()){
            categoria = "Ocio";
        }else if(rbNuevaDeporte.isChecked()){
            categoria = "Deporte";
        }else if(rbNuevaEstudios.isChecked()){
            categoria = "Estudios";
        }else if(rbNuevaTrabajo.isChecked()){
            categoria = "Trabajo";
        }
        return categoria;
    }

    private int obtenerImagen() {
        int imagen = 0;
        if(rbNuevaFamilia.isChecked()){
            imagen = R.drawable.familia;
        }else if(rbNuevaAmigos.isChecked()){
            imagen = R.drawable.amigo;
        }else if(rbNuevaOcio.isChecked()){
            imagen = R.drawable.ocio;
        }else if(rbNuevaDeporte.isChecked()){
            imagen = R.drawable.deporte;
        }else if(rbNuevaEstudios.isChecked()){
            imagen = R.drawable.estudios;
        }else if(rbNuevaTrabajo.isChecked()){
            imagen = R.drawable.trabajo;
        }
        return imagen;
    }

    private void initComponents() {
        txtNuevaNombre = findViewById(R.id.txtNuevaNombre);
        txtNuevaFecha = findViewById(R.id.txtNuevaFecha);
        txtNuevaHora = findViewById(R.id.txtNuevaHora);
        txtNuevaDescripcion = findViewById(R.id.txtNuevaDescripcion);
        btnAnhadir = findViewById(R.id.btnAnhadir);
        rgNuevaCategoria1 = findViewById(R.id.rgNuevaCategoria1);
        rgNuevaCategoria2 = findViewById(R.id.rgNuevaCategoria2);
        rbNuevaFamilia = findViewById(R.id.rbNuevaFamilia);
        rbNuevaAmigos = findViewById(R.id.rbNuevaAmigos);
        rbNuevaOcio = findViewById(R.id.rbNuevaOcio);
        rbNuevaDeporte = findViewById(R.id.rbNuevaDeporte);
        rbNuevaEstudios = findViewById(R.id.rbNuevaEstudios);
        rbNuevaTrabajo = findViewById(R.id.rbNuevaTrabajo);
    }
}