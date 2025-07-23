package java20tp;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== TEST SAUVEGARDE/CHARGEMENT AVEC DESSIN ALÉATOIRE =====\n");

        try {
            //Créer un dessin aléatoire
            System.out.println("1. Création d'un dessin aléatoire...");
            Dessin dessinAleatoire = new Dessin(FigureUtil.genere(8));

            // Afficher les figures créées
            System.out.println("\nFigures générées aléatoirement :");
            System.out.println("--------------------------------");
            int numero = 1;
            for (Figure f : dessinAleatoire.getFigures()) {
                System.out.println(numero++ + ". " + f);
            }

            //Sauvegarder
            String nomFichier = "dessinAleatoire.txt";
            System.out.println("\n2. Sauvegarde dans '" + nomFichier + "'...");
            FigureUtil.save(dessinAleatoire, nomFichier);
            System.out.println("Fichier créé !");

            //Pause pour modification manuelle
            System.out.println("Ouvre le fichier '" + nomFichier + "' avec un éditeur");
            System.out.println("Modifie :");
            System.out.println("Sauvegarde le fichier (Ctrl+S)");
            System.out.println("\nAppuie sur ENTRÉE quand c'est fait...");

            scanner.nextLine();

            //Recharger et comparer
            System.out.println("\n4. Rechargement du fichier modifié...");
            Dessin dessinModifie = FigureUtil.charge(nomFichier);
            System.out.println("Chargé avec succès\n");

            // Afficher les figures modifiées
            System.out.println("Figures après modifications :");
            System.out.println("--------------------------------");
            numero = 1;
            for (Figure f : dessinModifie.getFigures()) {
                System.out.println(numero++ + ". " + f);
            }

        } catch (DessinHorsLimiteException e) {
            System.err.println("Erreur : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur fichier : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}