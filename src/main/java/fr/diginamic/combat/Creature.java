package fr.diginamic.combat;

import java.util.Random;

public class Creature extends Entity {
    private int pointsScore;

    private Creature(String name, int forceMin, int forceMax, int hpMin, int hpMax, int pointsScore) {
        super(name,
                forceMin + new Random().nextInt(forceMax - forceMin + 1),
                hpMin + new Random().nextInt(hpMax - hpMin + 1)
        );
        this.pointsScore = pointsScore;
    }

    public static Creature createWolf(){
        return new Creature("Wolf", 3, 8, 5, 10, 1);
    }

    public static Creature createGoblin(){
        return new Creature("Goblin", 5, 10, 10, 15, 2);
    }

    public static Creature createTroll(){
        return new Creature("Troll", 10, 15, 20, 30, 5);
    }

    public static Creature createRandomCreature() {
        int type = new Random().nextInt(3);

        switch(type){
            case 0: return createWolf();
            case 1: return createGoblin();
            case 2: return createTroll();
            default: return null;
        }
    }

    public int getPointsScore(){
        return pointsScore;
    }

    public void showStats(){
        System.out.println(
                 "A " + name + "appears! " + "Stats:\n" +
                 "Force: " + strength + "\n" +
                 "HP: " + hp
        );
    }

}
