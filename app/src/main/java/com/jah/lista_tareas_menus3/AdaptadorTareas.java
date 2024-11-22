package com.jah.lista_tareas_menus3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorTareas extends RecyclerView.Adapter<AdaptadorTareas.HolderTareas>{
    //Clase para la disposicion de los elementos.

    List<Tarea> dataSet;
    Context context;

    public AdaptadorTareas(List<Tarea> dataSet) {
        this.dataSet = dataSet;
    }

    //Inflar el layout que queremos que se vea.
    @NonNull
    @Override
    public AdaptadorTareas.HolderTareas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
        return new HolderTareas(view);
    }

    //Nos muestra las tarjetas que se ven en pantalla.
    @Override
    public void onBindViewHolder(@NonNull AdaptadorTareas.HolderTareas holder, int position) {
        Tarea tarea = dataSet.get(position);
        //asignamos el interior de las tarjetas
        holder.imgvImagen.setImageResource(tarea.getImagen());
        holder.lblNombre.setText(tarea.getNombre());
        holder.lblFecha.setText(tarea.getFecha());
        holder.lblHora.setText(tarea.getHora());
        //detectamos cuando hacemos click sobre una tarjeta. Y guardamos su posicion
        holder.cvCard.setOnClickListener(view -> {
            int posicion = holder.getAdapterPosition();
            verTarea(posicion);
        });
    }
    //metodo que cambia de activity para ver la informacion de la tarjeta que hemos marcado.
    private void verTarea(int posicion) {
        Intent ver = new Intent(context, VerTarea.class);
        ver.putExtra("posicion", posicion);
        context.startActivity(ver);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    //Emparejamos la parte grafica del xml para usarlas en el programa.
    public static class HolderTareas extends RecyclerView.ViewHolder {

        CardView cvCard;
        TextView lblNombre, lblFecha, lblHora;
        ImageView imgvImagen;

        public HolderTareas(@NonNull View itemView) {
            super(itemView);

            cvCard = itemView.findViewById(R.id.cvCard);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblFecha = itemView.findViewById(R.id.lblFecha);
            lblHora = itemView.findViewById(R.id.lblHora);
            imgvImagen = itemView.findViewById(R.id.imgvImagen);
        }
    }
}
