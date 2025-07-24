package fr.diginamic.recensement;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LectureFichier {

    public static void main(String[] args) {
        ArrayList<Ville> villes = new ArrayList<>();
        String cheminFichier = "recensement.csv";

        try {
            String contenu = Files.readString(Paths.get(cheminFichier), StandardCharsets.UTF_8);
            String[] lignes = contenu.split("\n");

            System.out.println("Nombre total de lignes : " + lignes.length);

            for (int i = 1; i < lignes.length; i++) {
                String ligne = lignes[i].trim();
                if (ligne.isEmpty()) continue;

                String[] tokens = ligne.split(";");

                if (tokens.length >= 10) {
                    try {
                        String codeRegion = tokens[0].trim();
                        String nomRegion = tokens[1].trim();
                        String codeDepartement = tokens[2].trim();
                        String codeCommune = tokens[5].trim();
                        String nomCommune = tokens[6].trim();

                        String populationStr = tokens[9].trim().replaceAll("\\s", "");
                        int populationTotale = Integer.parseInt(populationStr);

                        Ville ville = new Ville(nomCommune, codeDepartement, nomRegion,
                                codeRegion, codeCommune, populationTotale);
                        villes.add(ville);

                    } catch (NumberFormatException e) {
                        System.err.println("Erreur parsing ligne " + (i+1));
                    }
                }
            }

            System.out.println("Villes chargées : " + villes.size());

            Recensement recensement = new Recensement();
            for (Ville ville : villes) {
                recensement.ajouterVille(ville);
            }

            afficherMenu(recensement);

        } catch (IOException e) {
            System.err.println("Erreur lecture fichier : " + e.getMessage());
        }
    }

    private static void afficherMenu(Recensement recensement) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        do {
            System.out.println("\nMenu :");
            System.out.println("1. Population d'une ville");
            System.out.println("2. Population d'un département");
            System.out.println("3. Population d'une région");
            System.out.println("4. Afficher les 10 régions les plus peuplées");
            System.out.println("5. Afficher les 10 départements les plus peuplés");
            System.out.println("6. Afficher les 10 villes les plus peuplées d'un département");
            System.out.println("7. Afficher les 10 villes les plus peuplées d'une région");
            System.out.println("8. Afficher les 10 villes les plus peuplées de France");
            System.out.println("9. Sortir");
            System.out.print("Votre choix : ");

            try {
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        new RecherchePopuVille().traiter(recensement, scanner);
                        break;
                    case 2:
                        new RecherchePopuDpt().traiter(recensement, scanner);
                        break;
                    case 3:
                        new RecherchePopuRegion().traiter(recensement, scanner);
                        break;
                    case 4:
                        new AffRegionsPlusPeuplees().traiter(recensement, scanner);
                        break;
                    case 5:
                        new AffDptPlusPeuplees().traiter(recensement, scanner);
                        break;
                    case 6:
                        new AffVilleDpt().traiter(recensement, scanner);
                        break;
                    case 7:
                        new AffVilleRegion().traiter(recensement, scanner);
                        break;
                    case 8:
                        new AffVilleFrance().traiter(recensement, scanner);
                        break;
                    case 9:
                        System.out.println("Au revoir.");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir entre 1 et 9.");
                }
            } catch (Exception e) {
                System.out.println("Choix invalide. Veuillez choisir entre 1 et 9.");
                scanner.nextLine();
            }
        } while (choix != 9);

        scanner.close();
    }
}