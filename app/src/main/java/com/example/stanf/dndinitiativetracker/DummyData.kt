package com.example.stanf.dndinitiativetracker

import android.arch.lifecycle.MutableLiveData
import com.example.stanf.dndinitiativetracker.domain.Abilities.*
import com.example.stanf.dndinitiativetracker.domain.Action
import com.example.stanf.dndinitiativetracker.domain.Monster
import com.example.stanf.dndinitiativetracker.domain.Trait

object DummyData {
    val monsterList = listOf<Monster>(
            Monster(
                    "Aboleth",
                    "Large",
                    "abberation",
                    17,
                    135,
                    "10 ft., swim 40 ft.",
                    mapOf(STR to 21, DEX to 9, CON to 15, INT to 18, WIS to 15, CHAR to 0),
                    mapOf("history" to 12, "perception" to 10),
                    listOf(
                            Trait("Amphibious", "The aboleth can breathe air and water"),
                            Trait("Mucous Cloud", "While underwater, the aboleth is surrounded by transformative mucus.")),
                    listOf(
                            Action("Multiattack", "The aboleth makes three tentacle attacks."),
                            Action("Tentacle", "Melee Weapon Attack: +9 to hit, reach 10 ft., one target. Hit: 12 (2d6 + 5) B"),
                            Action("Tail", "The aboleth targets one creature it can see within 30 ft. of it. The target must succeed on a DC 14 Wisdom saving throw or be magically charmed by the aboleth until the aboleth dies or until it is on a different plane of existence from the target. The charmed target is under the aboleth's control and can't take reactions, and the aboleth and the target can communicate telepathically with each other over any distance.\\nWhenever the charmed target takes damage, the target can repeat the saving throw. On a success, the effect ends. No more than once every 24 hours, the target can also repeat the saving throw when it is at least 1 mile away from the aboleth.")
                    )
            ),
            Monster(
                    "Acolyte",
                    "Medium",
                    "humanoid",
                    10,
                    9,
                    "30 ft.",
                    mapOf(STR to 10, DEX to 10, CON to 10, INT to 10, WIS to 14, CHAR to 11),
                    mapOf("medicine" to 4, "religion" to 2),
                    listOf(
                            Trait("Spellcasting", "The acolyte is a 1st-level spellcaster. Its spellcasting ability is Wisdom (spell save DC 12, +4 to hit with spell attacks). The acolyte has following cleric spells prepared:• Cantrips (at will): light, sacred flame, thaumaturgy 1st level (3 slots): bless, cure wounds, sanctuary")),
                    listOf(
                            Action("Club", "Melee Weapon Attack: +2 to hit, reach 5 ft., one target. Hit: 2 (1d4) bludgeoning damage.")
                    )
            ),
            Monster(
                    "Monster 3",
                    "Large",
                    "abberation",
                    16,
                    64,
                    "10 ft., swim 40 ft.",
                    mapOf(STR to 21, DEX to 9, CON to 15, INT to 18, WIS to 15, CHAR to 0),
                    mapOf("history" to 12, "perception" to 10),
                    listOf(
                            Trait("Amphibious", "The aboleth can breathe air and water"),
                            Trait("Mucous Cloud", "While underwater, the aboleth is surrounded by transformative mucus.")),
                    listOf(
                            Action("Multiattack", "The aboleth makes three tentacle attacks."),
                            Action("Tentacle", "Melee Weapon Attack: +9 to hit, reach 10 ft., one target. Hit: 12 (2d6 + 5) B"),
                            Action("Tail", "The aboleth targets one creature it can see within 30 ft. of it. The target must succeed on a DC 14 Wisdom saving throw or be magically charmed by the aboleth until the aboleth dies or until it is on a different plane of existence from the target. The charmed target is under the aboleth's control and can't take reactions, and the aboleth and the target can communicate telepathically with each other over any distance.\\nWhenever the charmed target takes damage, the target can repeat the saving throw. On a success, the effect ends. No more than once every 24 hours, the target can also repeat the saving throw when it is at least 1 mile away from the aboleth.")
                    )
            ),
            Monster(
                    "Monster 4",
                    "Medium",
                    "humanoid",
                    12,
                    76,
                    "30 ft.",
                    mapOf(STR to 10, DEX to 10, CON to 10, INT to 10, WIS to 14, CHAR to 11),
                    mapOf("medicine" to 4, "religion" to 2),
                    listOf(
                            Trait("Spellcasting", "The acolyte is a 1st-level spellcaster. Its spellcasting ability is Wisdom (spell save DC 12, +4 to hit with spell attacks). The acolyte has following cleric spells prepared:• Cantrips (at will): light, sacred flame, thaumaturgy 1st level (3 slots): bless, cure wounds, sanctuary")),
                    listOf(
                            Action("Club", "Melee Weapon Attack: +2 to hit, reach 5 ft., one target. Hit: 2 (1d4) bludgeoning damage.")
                    )
            ),
            Monster(
                    "Monster 5",
                    "Large",
                    "abberation",
                    9,
                    156,
                    "10 ft., swim 40 ft.",
                    mapOf(STR to 21, DEX to 9, CON to 15, INT to 18, WIS to 15, CHAR to 0),
                    mapOf("history" to 12, "perception" to 10),
                    listOf(
                            Trait("Amphibious", "The aboleth can breathe air and water"),
                            Trait("Mucous Cloud", "While underwater, the aboleth is surrounded by transformative mucus.")),
                    listOf(
                            Action("Multiattack", "The aboleth makes three tentacle attacks."),
                            Action("Tentacle", "Melee Weapon Attack: +9 to hit, reach 10 ft., one target. Hit: 12 (2d6 + 5) B"),
                            Action("Tail", "The aboleth targets one creature it can see within 30 ft. of it. The target must succeed on a DC 14 Wisdom saving throw or be magically charmed by the aboleth until the aboleth dies or until it is on a different plane of existence from the target. The charmed target is under the aboleth's control and can't take reactions, and the aboleth and the target can communicate telepathically with each other over any distance.\\nWhenever the charmed target takes damage, the target can repeat the saving throw. On a success, the effect ends. No more than once every 24 hours, the target can also repeat the saving throw when it is at least 1 mile away from the aboleth.")
                    )
            ),
            Monster(
                    "Monster 6",
                    "Medium",
                    "humanoid",
                    19,
                    44,
                    "30 ft.",
                    mapOf(STR to 10, DEX to 10, CON to 10, INT to 10, WIS to 14, CHAR to 11),
                    mapOf("medicine" to 4, "religion" to 2),
                    listOf(
                            Trait("Spellcasting", "The acolyte is a 1st-level spellcaster. Its spellcasting ability is Wisdom (spell save DC 12, +4 to hit with spell attacks). The acolyte has following cleric spells prepared:• Cantrips (at will): light, sacred flame, thaumaturgy 1st level (3 slots): bless, cure wounds, sanctuary")),
                    listOf(
                            Action("Club", "Melee Weapon Attack: +2 to hit, reach 5 ft., one target. Hit: 2 (1d4) bludgeoning damage.")
                    )
            ),
            Monster(
                    "Monster 7",
                    "Large",
                    "abberation",
                    10,
                    37,
                    "10 ft., swim 40 ft.",
                    mapOf(STR to 21, DEX to 9, CON to 15, INT to 18, WIS to 15, CHAR to 0),
                    mapOf("history" to 12, "perception" to 10),
                    listOf(
                            Trait("Amphibious", "The aboleth can breathe air and water"),
                            Trait("Mucous Cloud", "While underwater, the aboleth is surrounded by transformative mucus.")),
                    listOf(
                            Action("Multiattack", "The aboleth makes three tentacle attacks."),
                            Action("Tentacle", "Melee Weapon Attack: +9 to hit, reach 10 ft., one target. Hit: 12 (2d6 + 5) B"),
                            Action("Tail", "The aboleth targets one creature it can see within 30 ft. of it. The target must succeed on a DC 14 Wisdom saving throw or be magically charmed by the aboleth until the aboleth dies or until it is on a different plane of existence from the target. The charmed target is under the aboleth's control and can't take reactions, and the aboleth and the target can communicate telepathically with each other over any distance.\\nWhenever the charmed target takes damage, the target can repeat the saving throw. On a success, the effect ends. No more than once every 24 hours, the target can also repeat the saving throw when it is at least 1 mile away from the aboleth.")
                    )
            ),
            Monster(
                    "Monster 8",
                    "Medium",
                    "humanoid",
                    15,
                    60,
                    "30 ft.",
                    mapOf(STR to 10, DEX to 10, CON to 10, INT to 10, WIS to 14, CHAR to 11),
                    mapOf("medicine" to 4, "religion" to 2),
                    listOf(
                            Trait("Spellcasting", "The acolyte is a 1st-level spellcaster. Its spellcasting ability is Wisdom (spell save DC 12, +4 to hit with spell attacks). The acolyte has following cleric spells prepared:• Cantrips (at will): light, sacred flame, thaumaturgy 1st level (3 slots): bless, cure wounds, sanctuary")),
                    listOf(
                            Action("Club", "Melee Weapon Attack: +2 to hit, reach 5 ft., one target. Hit: 2 (1d4) bludgeoning damage.")
                    )
            ),
            Monster(
                    "Monster 9",
                    "Large",
                    "abberation",
                    14,
                    124,
                    "10 ft., swim 40 ft.",
                    mapOf(STR to 21, DEX to 9, CON to 15, INT to 18, WIS to 15, CHAR to 0),
                    mapOf("history" to 12, "perception" to 10),
                    listOf(
                            Trait("Amphibious", "The aboleth can breathe air and water"),
                            Trait("Mucous Cloud", "While underwater, the aboleth is surrounded by transformative mucus.")),
                    listOf(
                            Action("Multiattack", "The aboleth makes three tentacle attacks."),
                            Action("Tentacle", "Melee Weapon Attack: +9 to hit, reach 10 ft., one target. Hit: 12 (2d6 + 5) B"),
                            Action("Tail", "The aboleth targets one creature it can see within 30 ft. of it. The target must succeed on a DC 14 Wisdom saving throw or be magically charmed by the aboleth until the aboleth dies or until it is on a different plane of existence from the target. The charmed target is under the aboleth's control and can't take reactions, and the aboleth and the target can communicate telepathically with each other over any distance.\\nWhenever the charmed target takes damage, the target can repeat the saving throw. On a success, the effect ends. No more than once every 24 hours, the target can also repeat the saving throw when it is at least 1 mile away from the aboleth.")
                    )
            ),
            Monster(
                    "Monster 10",
                    "Medium",
                    "humanoid",
                    19,
                    23,
                    "30 ft.",
                    mapOf(STR to 10, DEX to 10, CON to 10, INT to 10, WIS to 14, CHAR to 11),
                    mapOf("medicine" to 4, "religion" to 2),
                    listOf(
                            Trait("Spellcasting", "The acolyte is a 1st-level spellcaster. Its spellcasting ability is Wisdom (spell save DC 12, +4 to hit with spell attacks). The acolyte has following cleric spells prepared:• Cantrips (at will): light, sacred flame, thaumaturgy 1st level (3 slots): bless, cure wounds, sanctuary")),
                    listOf(
                            Action("Club", "Melee Weapon Attack: +2 to hit, reach 5 ft., one target. Hit: 2 (1d4) bludgeoning damage.")
                    )
            )
    )
    var savedMonsters: MutableLiveData<MutableList<Monster>>

    init {
        savedMonsters = MutableLiveData()
        savedMonsters.value = mutableListOf()
    }
}