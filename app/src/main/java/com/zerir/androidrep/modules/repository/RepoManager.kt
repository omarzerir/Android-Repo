package com.zerir.androidrep.modules.repository

import androidx.lifecycle.LiveData
import com.zerir.androidrep.modules.repository.local.ILocalReference
import com.zerir.androidrep.modules.repository.local.RepoLocal
import com.zerir.androidrep.modules.repository.models.Character

class RepoManager private constructor() : ILocalReference {

    companion object {
        @Volatile
        private var INSTANCE: RepoManager? = null
        fun getInstance(): RepoManager {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = RepoManager()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private val repoLocal = RepoLocal()

    override fun addCharacter(character: Character) {
        repoLocal.addCharacter(character)
    }

    override fun removeAllCharacters() {
        repoLocal.removeAllCharacters()
    }

    override fun getAllCharacters(): LiveData<List<Character>> {
        return repoLocal.getAllCharacters()
    }
}