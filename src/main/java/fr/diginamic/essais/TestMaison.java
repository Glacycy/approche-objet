package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {
    public static void main(String[] args) {
        Maison maison = new Maison();

        //rdc
        maison.ajouterPiece(new Salon(25, 0));
        maison.ajouterPiece(new Cuisine(15, 0));
        maison.ajouterPiece(new SalleDeBain(8, 0));
        maison.ajouterPiece(new WC(3, 0));

        //1er étage
        maison.ajouterPiece(new Chambre(12, 1));
        maison.ajouterPiece(new Chambre(15, 1));
        maison.ajouterPiece(new SalleDeBain(6, 1));

        System.out.println("Superficie totale : " + maison.getSuperficieTotal() + " m²");
        System.out.println("Superficie rdc : " + maison.getSuperficieEtage(0) + " m²");
        System.out.println("Superficie 1er étage : " + maison.getSuperficieEtage(1) + " m²");

        System.out.println("Superficie des chambres : " + maison.getSuperficieParType("Chambre") + " m²");
        System.out.println("Nombre de salles de bain : " + maison.getNbPiecesParType("SalleDeBain"));

        System.out.println("\nTest avec null : ");
        maison.ajouterPiece(null);

        System.out.println("\nTest avec superficie négative :");
        maison.ajouterPiece(new Chambre(-5, 1));

        System.out.println("\nTest avec étage négatif :");
        maison.ajouterPiece(new Chambre(10, -1));
    }
}
