package fr.diginamic.combat;

public class Personnage {
    private int force;
    private int pv;
    private int score;

    public Personnage(int force, int pv) {
        this.force = force;
        this.pv = pv;
        this.score = 0;
    }
}
