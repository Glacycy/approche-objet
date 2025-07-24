package fr.diginamic.recensement;

import java.util.ArrayList;

public class Recensement {
    private ArrayList<Ville> villes;

    public Recensement(){
        this.villes = new ArrayList<>();
    }

    public ArrayList<Ville> getVilles() {
        return villes;
    }

    public void ajouterVille(Ville ville){
        this.villes.add(ville);
    }
    public int getNbVilles(){
        return this.villes.size();
    }
}
