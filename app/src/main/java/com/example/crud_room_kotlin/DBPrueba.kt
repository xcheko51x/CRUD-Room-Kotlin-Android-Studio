package com.example.crud_room_kotlin

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Usuario::class],
    version = 1
)
abstract class DBPrueba: RoomDatabase() {
    abstract fun daoUsuario(): DaoUsuario
}