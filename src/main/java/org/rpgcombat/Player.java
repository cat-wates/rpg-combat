package org.rpgcombat;

public class Player {

    int health = 1000;
    int level = 1;
    boolean isAlive = true;

//    public int giveDamage() {
//        int damage;
//
//    }

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
}
