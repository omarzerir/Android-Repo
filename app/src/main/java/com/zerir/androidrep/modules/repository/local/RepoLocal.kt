package com.zerir.androidrep.modules.repository.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.zerir.androidrep.App
import com.zerir.androidrep.modules.repository.models.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepoLocal : ILocalReference {

    private val charactersDao = App.database.createDao()
    private val allCharacters: LiveData<List<Character>>

    init {
        allCharacters = charactersDao.getAllCharacters()
    }

    override fun addCharacter(character: Character) {
        CoroutineScope(Dispatchers.IO).launch {
            charactersDao.addCharacter(character)
        }
    }

    override fun removeAllCharacters() {
        val list = allCharacters.value?.toTypedArray()
        Log.e("delete", "${allCharacters.value}")
        if(list != null) {
            Log.e("delete", "enter2")
            CoroutineScope(Dispatchers.IO).launch {
                charactersDao.removeAllCharacters(*list)
                Log.e("delete", "enter3")
            }
        }
    }

    override fun getAllCharacters(): LiveData<List<Character>> {
        return allCharacters
    }
}