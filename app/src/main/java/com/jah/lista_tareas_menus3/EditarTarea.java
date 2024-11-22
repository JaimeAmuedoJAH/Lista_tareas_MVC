package com.jah.lista_tareas_menus3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EditarTarea extends AppCompatActivity {

    EditText txtEditarNombre, txtEditarFecha, txtEditarHora, txtEditarDescripcion;
    Button btnEditarVolver, btnEditarEditar;
    RadioGroup rgCategoria1, rgCategoria2;
    RadioButton rbFamilia, rbAmigos, rbOcio, rbDeporte, rbEstudios, rbTrabajo;
    Intent editar;
    Tarea t;
    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar_tarea);
        initComponents();

        btnEditarVolver.setOnClickListener(view -> finish());
        btnEditarEditar.setOnClickListener(view -> modificar());
        rgCategoria1.setOnCheckedChangeListener((radioGroup, i) -> desmarcar(2));
        rgCategoria2.setOnCheckedChangeListener((radioGroup, i) -> desmarcar(1));
    }
    //Si marcamos una opcion de uno de los radiogroups opuestos se desmarcan los del otro.
    private void desmarcar(int i) {
        if(i == 1){
            rbFamilia.setChecked(false);
            rbAmigos.setChecked(false);
            rbOcio.setChecked(false);
        }else {
            rbDeporte.setChecked(false);
            rbEstudios.setChecked(false);
            rbTrabajo.setChecked(false);
        }
    }
    //Asociamos el valor de los campos(los modificados y los que no) para cambiarlo en nuestro array.
    private void modificar() {
        t.setNombre(txtEditarNombre.getText().toString());
        t.setFecha(txtEditarFecha.getText().toString());
        t.setHora(txtEditarHora.getText().toString());
        t.setDescripcion(txtEditarDescripcion.getText().toString());
        if(rbFamilia.isChecked()){
            t.setImagen(R.drawable.familia);
            t.setCategoria("Familia");
        }else if(rbAmigos.isChecked()){
            t.setImagen(R.drawable.amigo);
            t.setCategoria("Amigos");
        }else if(rbOcio.isChecked()){
            t.setImagen(R.drawable.ocio);
            t.setCategoria("Ocio");
        }else if(rbDeporte.isChecked()){
            t.setImagen(R.drawable.deporte);
            t.setCategoria("Deporte");
        }else if(rbEstudios.isChecked()){
            t.setImagen(R.drawable.estudios);
            t.setCategoria("Estudios");
        }else if(rbTrabajo.isChecked()){
            t.setImagen(R.drawable.trabajo);
            t.setCategoria("Trabajo");
        }
        GestionTarea.actualizarTarea(t, posicion);
        finish();
    }

    private void initComponents() {
        txtEditarNombre = findViewById(R.id.txtEditarNombre);
        txtEditarFecha = findViewById(R.id.txtEditarFecha);
        txtEditarHora = findViewById(R.id.txtEditarHora);
        txtEditarDescripcion = findViewById(R.id.txtEditarDescripcion);
        btnEditarVolver = findViewById(R.id.btnEditarVolver);
        rgCategoria1 = findViewById(R.id.rgCategoria1);
        rgCategoria2 = findViewById(R.id.rgCategoria2);
        btnEditarEditar = findViewById(R.id.btnEditarEditar);
        rbFamilia = findViewById(R.id.rbFamilia);
        rbAmigos = findViewById(R.id.rbAmigos);
        rbOcio = findViewById(R.id.rbOcio);
        rbDeporte = findViewById(R.id.rbDeporte);
        rbEstudios = findViewById(R.id.rbEstudios);
        rbTrabajo = findViewById(R.id.rbTrabajo);
        //recuperamos los datos en este caso la posicion en un int.
        editar = getIntent();
        posicion = editar.getIntExtra("posicion", 0);
        t = GestionTarea.getArrTarea().get(posicion);

        txtEditarNombre.setText(t.getNombre());
        txtEditarFecha.setText(t.getFecha());
        txtEditarHora.setText(t.getHora());
        txtEditarDescripcion.setText(t.getDescripcion());
        if(t.getImagen() == R.drawable.familia){
            rbFamilia.setChecked(true);
        }else if(t.getImagen() == R.drawable.amigo){
            rbAmigos.setChecked(true);
        }else if(t.getImagen() == R.drawable.ocio){
            rbOcio.setChecked(true);
        }else if(t.getImagen() == R.drawable.deporte){
            rbDeporte.setChecked(true);
        }else if(t.getImagen() == R.drawable.estudios){
            rbEstudios.setChecked(true);
        }else if(t.getImagen() == R.drawable.trabajo){
            rbTrabajo.setChecked(true);
        }
    }
}