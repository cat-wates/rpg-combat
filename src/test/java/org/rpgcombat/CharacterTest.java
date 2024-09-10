package org.rpgcombat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CharacterTest {

    @Test
    public void shouldReduceCharacterHealthFromDamageWhenCharacterLevelsAreTheSame() {
//        Given
        Character character1 = new Character();
//        When
        character1.takeDamage(50);
//        Then
        assertThat(character1.getHealth()).isEqualTo(950);
    }

    @Test
    public void shouldKillPlayerWhenDamageIsGreaterThanHealth() {
        //   Given
        Character character1 = new Character();
//        When
        character1.takeDamage(1001);
//        Then
        assertThat(character1.getHealth()).isEqualTo(0);
        assertThat(character1.isAlive()).isFalse();
    }



    @Test
    public void shouldHealIfPlayerIsAliveAndHealthIsLessThan1000() {
        //   Given
        Character character1 = new Character();
//        When
        character1.takeDamage(30);
        character1.heal();
//        Then
        assertThat(character1.getHealth()).isEqualTo(1000);
        assertThat(character1.isAlive()).isTrue();
    }

    @Test
    public void shouldNotHealIfPlayerIsDead() {
        //   Given
        Character character1 = new Character();
//        When
        character1.takeDamage(1001);
        character1.heal();
//        Then
        assertThat(character1.getHealth()).isEqualTo(0);
        assertThat(character1.isAlive()).isFalse();
    }

    @Test
    public void shouldNotHealIfPlayerIsAt1000Health() {
        //   Given
        Character character1 = new Character();
//        When
        character1.heal();
//        Then
        assertThat(character1.getHealth()).isEqualTo(1000);
        assertThat(character1.isAlive()).isTrue();
    }

    @Test
    public void shouldDefineHowMuchDamageIsDealtBasedOnPlayer1LevelAndPlayer2Level() {

    }

}