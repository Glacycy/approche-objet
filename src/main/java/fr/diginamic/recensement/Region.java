package fr.diginamic.recensement;

public class Region {
    private String nom;
    private int populationTotale;

    public Region(String nom, int populationTotale) {
        this.nom = nom;
        this.populationTotale = populationTotale;
    }

    public String getNom() {
        return nom;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    public void ajouterPopulation(int population) {
        this.populationTotale += population;
    }

    @Override
    public String toString() {
        return this.nom + " (" + this.populationTotale + " habitants)";
    }
}
