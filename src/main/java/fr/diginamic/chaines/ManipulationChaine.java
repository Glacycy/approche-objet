package fr.diginamic.chaines;

import fr.diginamic.entites.Salarie;

public class ManipulationChaine {
    public static void main(String[] args) {

        String chaine = "Durand;Marcel;2 523.5";

        char premierCaractere = chaine.charAt(0);
        System.out.println("Premier caractère: " + premierCaractere);

        int longueur = chaine.length();
        System.out.println("Longueur de la chaine: " + longueur);


        String portion = chaine.substring(0, 3);
        System.out.println("Substring : " + portion);


        int position = chaine.indexOf(';');
        System.out.println("Position du caractère: " + position);


        String nomFamille = chaine.substring(0, chaine.indexOf(';'));
        System.out.println("Nom de famille: " + nomFamille);

        String chaineMaj = nomFamille.toUpperCase();
        System.out.println("Nom en majuscule: " + chaineMaj);


        String chaineMin = nomFamille.toLowerCase();
        System.out.println("Nom en minuscule: " + chaineMin);

        String[] morceaux = chaine.split(";");
        System.out.println("Morceaux :");
        for (int i= 0; i < morceaux.length; i++) {
            System.out.println("[" + i + "] " + morceaux[i]);
        }

        //Salarie
        String nom = morceaux[0];
        String prenom = morceaux[1];

        String salaireStr = morceaux[2].replace(" ", "");
        System.out.println("Salaire sans espace" + salaireStr);

        double salaire = Double.parseDouble(salaireStr);
        System.out.println("Salaire en double : " + salaire);

        Salarie employe = new Salarie(nom, prenom, salaire);
        System.out.println("Objet créé : " + employe);
    }
}
