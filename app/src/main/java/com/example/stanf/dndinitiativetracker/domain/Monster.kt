package com.example.stanf.dndinitiativetracker.domain

import java.io.Serializable

data class Monster(
        //val index: Int,
        val name: String,
        val size: String,
        val type: String,
        val armourClass: Int,
        val hitPoints: Int,
        val speed: String,
        val abilities: Map<Abilities, Int>,
        val skills: Map<String, Int>,
        val traits: List<Trait>,
        val actions: List<Action>
) : PlayableCharacter, Serializable {
}