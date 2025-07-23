package fr.diginamic.combat;

import java.util.Random;

public abstract class Entity {

    protected String name;
    protected int strength;
    protected int hp;
    protected int hpMax;
    protected Random random = new Random();

    public Entity(String name, int strength, int hp) {
        this.name = name;
        this.strength = strength;
        this.hp = hp;
        this.hpMax = hp;
        this.random = new Random();
    }

    public int calculAtk() {
        return strength + 1 + random.nextInt(10);
    }

    public void takeDamages(int damages) {
        this.hp -= damages;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void heal(int heal) {
        this.hp = Math.min(this.hp + heal, this.hpMax);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void showStats() {
        System.out.println(name + " - Strength: " + strength + " - HP: " + hp + "/" + hpMax);
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getHp() {
        return hp;
    }

    public int getHpMax() {
        return hpMax;
    }
}
