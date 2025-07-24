package fr.diginamic.recensement;

import java.util.Scanner;

public class RecherchePopuRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Nom ou code de la région : ");
        String saisie = scanner.nextLine().trim();
        String saisieNormalisee = Utils.normaliser(saisie);

        int populationTotale = 0;
        boolean regionTrouvee = false;
        String nomRegionTrouvee = "";

        for (Ville ville : recensement.getVilles()) {
            String nomRegionNormalise = Utils.normaliser(ville.getNomRegion());

            boolean correspondNom = nomRegionNormalise.contains(saisieNormalisee);
            boolean correspondCode = ville.getCodeRegion().equals(saisie);

            if (correspondNom || correspondCode) {
                populationTotale += ville.getPopulationTotale();
                regionTrouvee = true;
                nomRegionTrouvee = ville.getNomRegion();
            }
        }

        if (regionTrouvee) {
            System.out.println("Population de la région " + nomRegionTrouvee +
                    " : " + populationTotale + " habitants");
        } else {
            System.out.println("Région \"" + saisie + "\" non trouvée.");
        }
    }
}