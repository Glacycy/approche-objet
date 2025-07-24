package fr.diginamic.recensement;

import java.util.Scanner;

public class RecherchePopuVille extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Entrez le nom de la ville : ");
        String saisie = scanner.nextLine();
        String saisieNormalisee = Utils.normaliser(saisie);

        for (Ville ville : recensement.getVilles()) {
            String nomVilleNormalise = Utils.normaliser(ville.getNom());

            if (nomVilleNormalise.contains(saisieNormalisee)) {
                System.out.println("Population de " + ville.getNom() + " : " +
                        ville.getPopulationTotale() + " habitants");
                return;
            }
        }

        System.out.println("Ville introuvable.");
    }
}