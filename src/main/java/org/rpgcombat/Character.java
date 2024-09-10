package org.rpgcombat;

public class Character {

    private double health = 1000;
    private int level = 1;
    private boolean isAlive = true;
    private int maxRange = 1;
    private int location;

    public Character() {

    }

    public Character(int maxRange, int location) {
        this.maxRange = maxRange;
        this.location = location;
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

    public void setLevel(int level) {
        this.level = level;
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

    public int getMaxRange() {
        return maxRange;
    }

    public int getLocation() { return location; }
}
