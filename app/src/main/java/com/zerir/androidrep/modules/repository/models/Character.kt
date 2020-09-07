package com.zerir.androidrep.modules.repository.models

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "characters-table")
data class Character(
    @PrimaryKey @Nullable val name: String = "",
    val score: Int = 0,
    val sheet: CharacterSheet = CharacterSheet()
): Serializable