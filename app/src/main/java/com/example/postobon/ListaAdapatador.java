package com.example.postobon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdapatador extends RecyclerView.Adapter<ListaAdapatador.viewHolder> {

    ArrayList<Trabajador> listadeDatos;

    public ListaAdapatador(ArrayList<Trabajador> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public ListaAdapatador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,null,false);


        return new viewHolder(vistaDelItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdapatador.viewHolder holder, int position) {
        holder.actualizarDatos(listadeDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView nombreTrabajador;
        ImageView fotoTrabajador;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTrabajador = itemView.findViewById(R.id.nombrePerfil);
            fotoTrabajador = itemView.findViewById(R.id.fotoPerfil);
        }

        public void actualizarDatos(Trabajador trabajador) {
            nombreTrabajador.setText(trabajador.getNombreTrabajador());
            fotoTrabajador.setImageResource(trabajador.getFotoTrabajador());
        }
    }
}
