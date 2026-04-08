# Acid Dissolving Effect
Coming into contact with Acid gives `Level 1` of this effect to the entity for `7.5 seconds` *(`150 ticks`)*.

## Damage
This describes the amount damage given by the `Acid Dissolving` effect.

### On effect applied
- If the level is below 5, `1.5` damage of type `acid_damage` is dealt
- If the level is at or above 5, damage of type `acid_damage` is dealt according to the formula `(a - 2) * 3.05 + 1.5` where `a` is the amplifier

### On each active tick
- Damage of type `acid_damage` is dealt according to the rounded-up result of the formula, `(a + 1.05) * 1.18` where `a` is the amplifier
- If the player is `≥ 1.9` blocks deep in Acid, 2 damage of type `acid_drowning` is dealt

## Damage Types
This section describes all damage types associated with Acid.

### Acid Damage:
- Scales with difficulty
- Has an exhaustion value of `0.92`

### Acid Drowning
- Does not scale with difficulty
- Has an exhaustion value of `0.6`
