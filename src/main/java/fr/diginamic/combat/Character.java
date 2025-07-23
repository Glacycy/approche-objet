package fr.diginamic.combat;

public class Character extends Entity {
    private int score;
    private int bonusAtkTemp;
    private int durationBonus;
    private Inventory inventory;

    public Character() {
        super("Protagonist", 12 + new java.util.Random().nextInt(7), 20 + new java.util.Random().nextInt(31));
        this.score = 0;
        this.bonusAtkTemp = 0;
        this.durationBonus = 0;
        this.inventory = new Inventory(1, 1, 1);
    }

    public Character(int strength, int hp) {
        super("Protagonist", strength, hp);
        this.score = 0;
        this.bonusAtkTemp = 0;
        this.durationBonus = 0;
        this.inventory = new Inventory(1, 1, 1);
    }

    public int calculerAtk() {
        int atk = strength + 1 + random.nextInt(10) + bonusAtkTemp;

        if(durationBonus > 0) {
            durationBonus--;
            if (durationBonus == 0) {
                bonusAtkTemp = 0;
            }
        }
        return atk;
    }

    public void applyBonusAtk(int bonus, int duration){
        this.bonusAtkTemp = bonus;
        this.durationBonus = duration;
    }

    public void increaseScore(int points) {
        this.score += points;
    }


    public int getScore(){
        return this.score;
    }
    public Inventory getInventory(){
        return this.inventory;
    }

    public void showStats(){
        System.out.println("Strength : " + this.strength);
        System.out.println("HP : " + this.hp);
        System.out.println("Score : " + this.score);
        if (bonusAtkTemp > 0) {
            System.out.println("Temporary Bonus Attack : " + this.bonusAtkTemp + " until " + this.durationBonus + " turns");
        }
    }
}
