package com.zerir.androidrep.modules.repository.models

class GenerateCharacter {

    fun generateChar(name: String, round1: Int, round2: Int, round3: Int): Character {
        val score = calculateScore(round1, round2, round3)
        return Character(name, score, CharacterSheet(round1, round2, round3))
    }

    private fun calculateScore(round1: Int, round2: Int, round3: Int): Int {
        return (round1) + (round2 * 10) + (round3 * 20)
    }

}