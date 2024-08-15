package org.rpgcombat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThat;

class CombatTest {

    @Test
    public void shouldDealDamageToOpponent() {
//        Given
        Player player1 = new Player();
        Player player2 = new Player();
//        when
        Combat combat = new Combat(player1);
        combat.attack(player2);
//        then
        assertThat(player2.getHealth()).isEqualTo(950);
    }

    @Test
    public void shouldEnsurePlayerCannotAttackItself() {
//        Given
        Player player2 = new Player();
//        when
        Combat combat = new Combat(player2);
//        then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            combat.attack(player2);
        }).withMessageMatching("A player cannot deal damage to itself!");
    }

    @Test
    public void shouldIncreaseDamageWhenAttackerLevelIs5LevelsOrMoreAboveDefenderLevel() {
//        Given
        Player attacker = new Player(6);
        Player defender = new Player();
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        Assertions.assertThat(defender.getHealth()).isEqualTo(925);
    }

    @Test
    public void shouldDecreaseDamageWhenAttackerLevelIs5LevelsOrMoreBelowDefenderLevel() {
//        Given
        Player attacker = new Player();
        Player defender = new Player(6);
//        When
        Combat combat = new Combat(attacker);
        combat.attack(defender);
//        Then
        Assertions.assertThat(defender.getHealth()).isEqualTo(975);
    }
}