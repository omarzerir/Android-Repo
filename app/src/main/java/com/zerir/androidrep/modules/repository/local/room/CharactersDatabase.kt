package com.zerir.androidrep.modules.repository.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zerir.androidrep.modules.repository.models.Character
import com.zerir.androidrep.utils.SheetTypeConverter

@Database(entities = [(Character::class)], version = 2)
@TypeConverters(SheetTypeConverter::class)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun createDao(): CharactersDao

}