package com.jah.lista_tareas_menus3;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GestionTarea {

    //Clase que gestiona todas las modificaciones de la lista.

    private static List<Tarea> arrTarea;

    public GestionTarea() {
    }

    public static List<Tarea> getArrTarea() {
        return arrTarea;
    }

    public static void setArrTarea(List<Tarea> arrTarea) {
        GestionTarea.arrTarea = arrTarea;
    }

    public static void actualizarTarea(Tarea tarea ,int posicion){
        arrTarea.set(posicion, tarea);
        GestionTarea.setArrTarea(arrTarea);
    }

    public static void anhadirTarea(Tarea tarea){
        arrTarea.add(tarea);
        GestionTarea.setArrTarea(arrTarea);
    }

    public static void ordenarPorCategoria(){
        arrTarea.sort((tarea1, tarea2) -> tarea1.getCategoria().compareToIgnoreCase(tarea2.getCategoria()));
    }

    public static void ordenarPorFecha(){
        arrTarea.sort((tarea1, tarea2) -> tarea1.getFecha().compareToIgnoreCase(tarea2.getFecha()));
    }

    public static List<Tarea> cargarDatos(){
        arrTarea = new ArrayList<>();
        Tarea tarea;
        tarea = new Tarea("Finde con la familia", "23/11/2024", "9:00", "Ir de viaje a algun pueblo cercano con la familia" , "Familia" , R.drawable.familia);
        arrTarea.add(tarea);
        tarea = new Tarea("Estudiar PMDM", "24/11/2024", "10:00", "Estudiar para el examen del miercoles" , "Estudios" , R.drawable.estudios);
        arrTarea.add(tarea);
        tarea = new Tarea("Ver Arcane", "24/11/2024", "16:00", "Ver la temporada nueva de Arcane" , "Ocio" , R.drawable.ocio);
        arrTarea.add(tarea);
        tarea = new Tarea("Terminar aplicación", "25/11/2024", "8:00", "Terminar la aplicación que hay que hacer en el trabajo" , "Trabajo" , R.drawable.trabajo);
        arrTarea.add(tarea);
        tarea = new Tarea("Cenar con amigos", "23/11/2024", "21:00", "Quedar el sabado para cenar con los amigos" , "Amigos" , R.drawable.amigo);
        arrTarea.add(tarea);
        tarea = new Tarea("Ir a entrenar", "26/11/2024", "10:00", "Quedar para entrenar con un compañero" , "Deporte" , R.drawable.deporte);
        arrTarea.add(tarea);
        return arrTarea;
    }
}
