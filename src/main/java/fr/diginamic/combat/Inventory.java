package fr.diginamic.combat;

import java.util.Random;

public class Inventory {
    private int potionHeal;
    private int potionAtkMin;
    private int potionAtkMax;
    private Random random = new Random();

    public Inventory(int potionHeal, int potionAtkMin, int potionAtkMax) {
        this.potionHeal = potionHeal;
        this.potionAtkMin = potionAtkMin;
        this.potionAtkMax = potionAtkMax;
        this.random = new Random();
    }

    public boolean useHealPotion(Character character) {
        if (potionHeal > 0) {
            int heal = 5 + random.nextInt(6);
            character.heal(heal);
            potionHeal--;
            System.out.println("You drink a healing potion and heal " + heal + " HP. You have " + potionHeal + " potions left.");
            return true;
        }
        System.out.println("You don't have any healing potions left.");
        return false;
    }

    public boolean usePotionAtkMax(Character character) {
        if (potionAtkMax > 0) {
            character.applyBonusAtk(5, 2);
            potionAtkMax--;
            System.out.println("You drink a strong attack potion and increase your attack by 5 for 2 fights. You have " + potionAtkMax + " potions left.");
            return true;
        } else {
            System.out.println("You don't have any strong attack potions left.");
            return false;
        }
    }

    public boolean usePotionAtkMin(Character character) {
        if (potionAtkMin > 0) {
            character.applyBonusAtk(3, 1);
            potionAtkMin--;
            System.out.println("You drink a weak attack potion and increase your attack by 3 for 1 fight. You have " + potionAtkMin + " potions left.");
            return true;
        } else {
            System.out.println("You don't have any weak attack potions left.");
            return false;
        }
    }

    public void addPotionHeal(){
        potionHeal++;
    }

    public void addPotionAtkMin(){
        potionAtkMin++;
    }

    public void addPotionAtkMax(){
        potionAtkMax++;
    }

    public boolean hasPotions(){
        return potionHeal > 0 || potionAtkMin > 0 || potionAtkMax > 0;
    }

    public void showInventory(){
        System.out.println("1. Healing potions : " + potionHeal);
        System.out.println("2. Weak attack potions : " + potionAtkMin);
        System.out.println("3. Strong attack potions : " + potionAtkMax);
    }

    public int getPotionHeal() {
        return potionHeal;
    }

    public int getPotionAtkMin() {
        return potionAtkMin;
    }

    public int getPotionAtkMax() {
        return potionAtkMax;
    }
}
