package fr.diginamic.essais;

import fr.diginamic.entites.Theatre;

public class TestTheatre {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympia", 100);

        theatre.inscrire(30, 25);
        System.out.println("Spectateurs inscrits : " + theatre.getNbSpectateursTotal());

        theatre.inscrire(40, 30);
        System.out.println("Spectateurs inscrits : " + theatre.getNbSpectateursTotal());

        theatre.inscrire(25, 20);
        System.out.println("Spectateurs inscrits : " + theatre.getNbSpectateursTotal());

        theatre.inscrire(10, 15); //affiche erreur

        System.out.println("Total de spectateurs : " + theatre.getNbSpectateursTotal());

        System.out.println("Recette totale : " + theatre.getRecetteTotal() + " euros");

    }
}
