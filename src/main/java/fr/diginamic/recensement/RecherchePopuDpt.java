package fr.diginamic.recensement;

import java.util.Scanner;

public class RecherchePopuDpt extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Code du département (ex: 34, 2A) : ");
        String codeDpt = scanner.nextLine().trim();

        int populationTotale = 0;
        boolean departementTrouve = false;

        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeDepartement().equalsIgnoreCase(codeDpt)) {
                populationTotale += ville.getPopulationTotale();
                departementTrouve = true;
            }
        }

        if (departementTrouve) {
            System.out.println("Population du département " + codeDpt + " : " +
                    populationTotale + " habitants");
        } else {
            System.out.println("Département " + codeDpt + " non trouvé.");
        }
    }
}