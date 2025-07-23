package fr.diginamic.combat;

public class Game {
    private Character character;
    private Fight gestFight;
    private Menu menu;

    public Game() {
        this.gestFight = new Fight();
        this.menu = new Menu();
    }

    public void start() {
        System.out.println("Welcome to the game!");

        boolean gameOn = true;

        while (gameOn) {
            menu.showMainMenu();
            int choice = menu.readUserChoice();

            switch (choice) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    fightCreature();
                    break;
                case 3:
                    usePotion();
                    break;
                case 4:
                    showScore();
                    break;
                case 5:
                    gameOn = false;
                    menu.showInfo("Thanks for playing! Goodbye!");
                    break;
                default:
                    menu.showError("Invalid choice. Please try again.");
            }

            if (gameOn && choice != 5){
                menu.waitUser();
            }
        }
        menu.close();
    }

    private void createCharacter() {
        character = new Character();
        menu.showSuccess("Character created successfully!");
        character.showStats();

        System.out.println("\nInventory: ");
        character.getInventory().showInventory();
    }

    private void fightCreature() {
        if (!characterExist()){
            return;
        }

        if (!characterIsNotAlive()){
            return;
        }
        gestFight.startCombat(character);
    }

    private void usePotion() {
        if (!characterExist()){
            return;
        }

        if (!characterIsNotAlive()){
            return;
        }

        if (!character.getInventory().hasPotions()){
            menu.showError("You don't have any potions to use.");
            return;
        }

        int potionChoice = menu.showPotionMenu(character.getInventory());

        boolean potionUsed = false;
        switch (potionChoice) {
            case 1:
                potionUsed = character.getInventory().useHealPotion(character);
                break;
            case 2:
                potionUsed = character.getInventory().usePotionAtkMin(character);
                break;
            case 3:
                potionUsed = character.getInventory().usePotionAtkMax(character);
                break;
            case 0:
                menu.showInfo("Go back to main menu.");
                return;
            default:
                menu.showError("Invalid choice. Please try again.");
                return;
        }

        if (potionUsed) {
            menu.showSuccess("\nPotion used successfully!");
            System.out.println("\nStats: ");
            character.showStats();
        }
    }

    private void showScore() {
        if (!characterExist()){
            return;
        }

        System.out.println("Your score is " + character.getScore() + " points.");

        if (character.isAlive()){
            character.showStats();
        } else {
            System.out.println("You are dead.");
        }
    }

    private boolean characterExist() {
        if (character == null) {
            menu.showError("You need to create a character first.");
            return false;
        }
        return true;
    }

    private boolean characterIsNotAlive() {
        if (!character.isAlive()){
            menu.showError("You are dead. You need to create a new character.");
            menu.showInfo("Your score were " + character.getScore() + " points. Please create a new character and try again.");
            return false;
        }
        return true;
    }
}
