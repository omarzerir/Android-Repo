package com.zerir.androidrep

import android.app.Application
import androidx.room.Room
import com.zerir.androidrep.modules.repository.local.room.CharactersDatabase

class App : Application() {

    companion object {
        lateinit var database: CharactersDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, CharactersDatabase::class.java, "character-db")
            .fallbackToDestructiveMigration()
            .build()
    }
}