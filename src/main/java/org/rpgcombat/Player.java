package org.rpgcombat;

public class Player {

    private double health = 1000;
    private int level = 1;
    private boolean isAlive = true;

    public Player() {

    }

    public Player(int level) {
        this.level = level;
    }

    public void takeDamage(int damage) {
        if (health - damage < 0) {
            health = 0;
            isAlive = false;
        }
        else {
            health = health - damage;
        }
    }

    public void heal() {
        if (isAlive && health < 1000) {
            health = 1000;
        }
    }

    public double getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
