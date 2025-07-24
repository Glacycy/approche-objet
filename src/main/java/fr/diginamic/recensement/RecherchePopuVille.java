package fr.diginamic.recensement;

import java.util.Scanner;

public class RecherchePopuVille extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Entrez le nom ou le code de la ville : ");
        String saisie = scanner.nextLine();
        String saisieNormalisee = Utils.normaliser(saisie);

        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeCommune().equals(saisie) ||
                    Utils.normaliser(ville.getNom()).contains(saisieNormalisee)) {

                System.out.println("Population de " + ville.getNom() + " : " +
                        ville.getPopulationTotale() + " habitants");
                return;
            }
        }

        System.out.println("Ville introuvable.");
    }
}