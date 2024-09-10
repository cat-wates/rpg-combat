package org.rpgcombat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThat;

class CombatTest {

    @Test
    public void shouldDealDamageToOpponent() {
//        Given
        Character character1 = new Character();
        Character character2 = new Character();
//        when
        Combat combat = new Combat(character1);
        combat.attack(character2);
//        then
        assertThat(character2.getHealth()).isEqualTo(950);
    }

    @Test
    public void shouldEnsurePlayerCannotAttackItself() {
//        Given
        Character character2 = new Character();
//        when
        Combat combat = new Combat(character2);
//        then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            combat.attack(character2);
        }).withMessageMatching("A player cannot deal damage to itself!");
    }

    @Test
    public void shouldIncreaseDamageWhenAttackerLevelIs5LevelsOrMoreAboveDefenderLevel() {
//        Given
        Character attacker = new Character();
        Character defender = new Character();
        attacker.setLevel(6);
        defender.setLevel(1);
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        Assertions.assertThat(defender.getHealth()).isEqualTo(925);
    }

    @Test
    public void shouldDecreaseDamageWhenAttackerLevelIs5LevelsOrMoreBelowDefenderLevel() {
//        Given
        Character attacker = new Character();
        Character defender = new Character();
        attacker.setLevel(1);
        defender.setLevel(6);
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        Assertions.assertThat(defender.getHealth()).isEqualTo(975);
    }

    @Test
    public void shouldAttackWhenDistanceBetweenCharactersIsPositiveAndInRange() {
//        Given
        Character attacker = new Character(5, 24);
        Character defender = new Character(5, 20);
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        assertThat(defender.getHealth()).isEqualTo(950);
    }

    @Test
    public void shouldAttackWhenDistanceBetweenCharactersIsNegativeAndInRange() {
        //        Given
        Character attacker = new Character(5, 20);
        Character defender = new Character(5, 24);
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        assertThat(defender.getHealth()).isEqualTo(950);
    }

    @Test
    public void shouldNotAttackWhenDistanceBetweenCharactersIsPositiveAndNotInRange() {
        //        Given
        Character attacker = new Character(5, 26);
        Character defender = new Character(5, 20);
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        assertThat(defender.getHealth()).isEqualTo(1000);
    }

    @Test
    public void shouldNotAttackWhenDistanceBetweenCharactersIsNegativeAndNotInRange() {
        //        Given
        Character attacker = new Character(5, 20);
        Character defender = new Character(5, 26);
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        assertThat(defender.getHealth()).isEqualTo(1000);
    }


}