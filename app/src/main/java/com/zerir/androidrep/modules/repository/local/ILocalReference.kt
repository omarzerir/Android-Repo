package com.zerir.androidrep.modules.repository.local

import androidx.lifecycle.LiveData
import com.zerir.androidrep.modules.repository.models.Character

interface ILocalReference {

    fun addCharacter(character: Character)

    fun removeAllCharacters()

    fun getAllCharacters(): LiveData<List<Character>>

}