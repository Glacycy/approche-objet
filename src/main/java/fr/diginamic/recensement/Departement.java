package fr.diginamic.recensement;

public class Departement {
    private String code;
    private String nom;
    private int populationTotale;

    public Departement(String code, int populationTotale) {
        this.code = code;
        this.populationTotale = populationTotale;
    }

    public String getCode() {
        return code;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    public void ajouterPopulation(int population) {
        this.populationTotale += population;
    }

    @Override
    public String toString() {
        return "Département " + code + " (" + populationTotale + " habitants)";
    }
}
