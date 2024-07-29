package org.rpgcombat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PlayerTest {

    @Test
    public void shouldReduceCharacterHealthFromDamage() {
//        Given
        Player player1 = new Player();
//        When
        player1.takeDamage(50);
//        Then
        assertThat(player1.health).isEqualTo(950);
    }

    @Test
    public void shouldKillPlayerWhenDamageIsGreaterThanHealth() {
        //   Given
        Player player1 = new Player();
//        When
        player1.takeDamage(1001);
//        Then
        assertThat(player1.health).isEqualTo(0);
        assertThat(player1.isAlive).isFalse();
    }

    @Test
    public void shouldHealIfPlayerIsAliveAndHealthIsLessThan1000() {
        //   Given
        Player player1 = new Player();
//        When
        player1.takeDamage(30);
        player1.heal();
//        Then
        assertThat(player1.health).isEqualTo(1000);
        assertThat(player1.isAlive).isTrue();
    }

    @Test
    public void shouldNotHealIfPlayerIsDead() {
        //   Given
        Player player1 = new Player();
//        When
        player1.takeDamage(1001);
        player1.heal();
//        Then
        assertThat(player1.health).isEqualTo(0);
        assertThat(player1.isAlive).isFalse();
    }

    @Test
    public void shouldNotHealIfPlayerIsAt1000Health() {
        //   Given
        Player player1 = new Player();
//        When
        player1.heal();
//        Then
        assertThat(player1.health).isEqualTo(1000);
        assertThat(player1.isAlive).isTrue();
    }

}