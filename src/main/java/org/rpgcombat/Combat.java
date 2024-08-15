package org.rpgcombat;

public class Combat {

    private Player attacker;

    public Combat(Player attacker) {
        this.attacker = attacker;
    }

    public int defineDamage() {
        return 50;
    }

    public void attack(Player defender) throws IllegalArgumentException {
        if (defender != attacker) {
            if (attacker.getLevel() - defender.getLevel() >= 5) {
                defender.takeDamage(75);
            }
            else if (defender.getLevel() - attacker.getLevel() >= 5) {
                defender.takeDamage(25);
            } else {
                defender.takeDamage(50);
            }
        } else {
            throw new IllegalArgumentException("A player cannot deal damage to itself!");
        }
    }
}
