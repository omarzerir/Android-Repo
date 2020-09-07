package com.zerir.androidrep.modules.repository.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zerir.androidrep.modules.repository.models.Character

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(character: Character)

    @Delete
    fun removeAllCharacters(vararg vararg: Character)

    @Query("SELECT * FROM `characters-table` ORDER BY name ASC")
    fun getAllCharacters(): LiveData<List<Character>>
}