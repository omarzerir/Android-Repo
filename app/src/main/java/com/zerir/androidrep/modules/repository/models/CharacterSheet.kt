package com.zerir.androidrep.modules.repository.models

import java.io.Serializable

data class CharacterSheet(
    val round1: Int = 0,
    val round2: Int = 0,
    val round3: Int = 0
): Serializable