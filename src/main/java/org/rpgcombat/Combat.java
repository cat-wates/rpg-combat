package org.rpgcombat;

import static java.lang.Math.abs;

public class Combat {

    private final Character attacker;

    public Combat(Character attacker) {
        this.attacker = attacker;
    }

    public void attack(Character defender) throws IllegalArgumentException {
        if (isInRange(defender)) {
            if (defender != attacker) {
                int damage = defineDamage(defender);
                defender.takeDamage(damage);
            } else {
                throw new IllegalArgumentException("A player cannot deal damage to itself!");
            }
        }
    }

    private int defineDamage(Character defender) {
        int damage = 50;
        if (attacker.getLevel() - defender.getLevel() >= 5) {
            damage = 75;
        }
        else if (defender.getLevel() - attacker.getLevel() >= 5) {
            damage = 25;
        }
        return damage;
    }

    private boolean isInRange(Character defender) {
        int distance = abs(attacker.getLocation() - defender.getLocation());
        return distance >= 0 && distance <= attacker.getMaxRange(); //returns true or false
    }
}
