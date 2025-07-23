package fr.diginamic.combat;

import java.util.Random;

public class Fight {
    private Random random = new Random();

    public void startCombat(Character character) {
        Creature creature = Creature.createRandomCreature();

        System.out.println("\nFight!");
        creature.showStats();
        System.out.println();

        int turn = 1;
        while (character.isAlive() && creature.isAlive()){
            System.out.println("\nTurn " + turn + ":\n");

            int atkCharacter = character.calculerAtk();
            int atkCreature = creature.calculAtk();

            System.out.println("Your attack: " + atkCharacter);
            System.out.println(creature.getName() + "'s attack: " + atkCreature);

            if(atkCharacter > atkCreature) {
                int damages = atkCharacter - atkCreature;
                creature.takeDamages(damages);
                System.out.println("You deal " + damages + " damages to " + creature.getName() + "!");
                System.out.println(creature.getName() + " has " + creature.getHp() + " HP left.");
            } else if (atkCreature > atkCharacter) {
                int damages = atkCreature - atkCharacter;
                character.takeDamages(damages);
                System.out.println(creature.getName() + " deals " + damages + " damages to you!");
                System.out.println("You have " + character.getHp() + " HP left.");
            } else {
                System.out.println("It's a draw! No damage done.");
            }

            System.out.println();
            turn++;
        }

        if (character.isAlive()) {
            victory(character, creature);
        } else {
            defeat(character, creature);
        }
    }

    private void victory(Character character, Creature creature) {
        character.increaseScore(creature.getPointsScore());
        System.out.println("You win " + creature.getPointsScore() + " points.");
        System.out.println("Your score is now " + character.getScore() + ".");

        if (random.nextBoolean()) {
            giveReward(character);
        }
    }

    private void defeat(Character character, Creature creature) {
        System.out.println("You lose! You were killed by " + creature.getName() + "!");
        System.out.println("Game Over! You scored " + character.getScore() + " points.");
        System.out.println("Please create a new character and try again.");
    }

    private void giveReward(Character character) {
       int typeReward = random.nextInt(4);
       System.out.println("\nYou received a reward!");

       switch (typeReward) {
           case 0:
               character.getInventory().addPotionHeal();
               System.out.println("You received a healing potion!");
               break;
           case 1:
               character.getInventory().addPotionAtkMin();
               System.out.println("You received a weak attack potion!");
               break;
           case 2:
               character.getInventory().addPotionAtkMax();
               System.out.println("You received a strong attack potion!");
               break;
           case 3:
               character.increaseScore(5);
               System.out.println("You received 5 bonus points!");
               break;
       }
    }
}

