package fr.diginamic.recensement;

public class Ville {
    private String nom;
    private String codeDepartement;
    private String nomRegion;
    private String codeRegion;
    private String nomCommune;
    private String codeCommune;
    private int populationTotale;

    public Ville(String nom, String codeDepartement, String nomRegion, String codeRegion, int populationTotale) {
        this.nom = nom;
        this.codeDepartement = codeDepartement;
        this.nomRegion = nomRegion;
        this.populationTotale = populationTotale;
        this.codeRegion = codeRegion;
    }

    public String getNom() {
        return nom;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public int getPopulationTotale() {
        return populationTotale;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public String getCodeCommune() {
        return codeCommune;
    }

    @Override
    public String toString() {
        return nom + " (" + codeDepartement + ") - " + nomRegion + " : " + populationTotale + " habitants";
    }
}