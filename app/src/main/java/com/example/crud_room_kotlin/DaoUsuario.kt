package com.example.crud_room_kotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoUsuario {

    @Query("SELECT * FROM usuarios")
    suspend fun obtenerUsuarios(): MutableList<Usuario>

    @Insert
    suspend fun agregarUsuario(usuario: Usuario)

    @Query("UPDATE usuarios set pais=:pais WHERE usuario=:usuario")
    suspend fun actualizarUsuario(usuario: String, pais: String)

    @Query("DELETE FROM usuarios WHERE usuario=:usuario")
    suspend fun borrarUsuario(usuario: String)

}