package com.example.crud_room_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorUsuarios(
    val listaUsuarios: MutableList<Usuario>,
    val listener: AdaptadorListener
): RecyclerView.Adapter<AdaptadorUsuarios.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_usuario, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = listaUsuarios[position]

        holder.tvUsuario.text = usuario.usuario
        holder.tvPais.text = usuario.pais

        holder.cvUsuario.setOnClickListener {
            listener.onEditItemClick(usuario)
        }

        holder.btnBorrar.setOnClickListener {
            listener.onDeleteItemClick(usuario)
        }
    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val cvUsuario = itemView.findViewById<CardView>(R.id.cvUsuario)
        val tvUsuario = itemView.findViewById<TextView>(R.id.tvUsuario)
        val tvPais = itemView.findViewById<TextView>(R.id.tvPais)
        val btnBorrar = itemView.findViewById<Button>(R.id.btnBorrar)
    }

}