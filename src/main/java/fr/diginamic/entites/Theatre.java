package fr.diginamic.entites;

public class Theatre {
    private String name;
    private int capacity;
    private int nbSpectateursTotal;
    private int recetteTotal;

    public Theatre(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.nbSpectateursTotal = 0;
        this.recetteTotal = 0;
    }

    public void inscrire(int nbSpectateurs, int prixPlace) {
        if (nbSpectateurs + nbSpectateursTotal <= capacity) {
            nbSpectateursTotal += nbSpectateurs;
            recetteTotal += nbSpectateurs * prixPlace;
        }
        else {
            System.out.println("Le spectacle est plein");
        }
    }

    public int getNbSpectateursTotal() {
        return nbSpectateursTotal;
    }

    public int getRecetteTotal() {
        return recetteTotal;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
