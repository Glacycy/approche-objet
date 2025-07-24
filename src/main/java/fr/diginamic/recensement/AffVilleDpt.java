package fr.diginamic.recensement;

import java.util.*;

public class AffVilleDpt extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Code du département : ");
        String codeDpt = scanner.nextLine();

        List<Ville> villesDuDpt = new ArrayList<>();
        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeDepartement().equals(codeDpt)) {
                villesDuDpt.add(ville);
            }
        }

        if (villesDuDpt.isEmpty()) {
            System.out.println("Aucune ville trouvée pour le département " + codeDpt);
            return;
        }

        villesDuDpt.sort((v1, v2) -> Integer.compare(v2.getPopulationTotale(), v1.getPopulationTotale()));

        System.out.println("Les 10 villes les plus peuplées du département " + codeDpt + " :");
        for (int i = 0; i < Math.min(10, villesDuDpt.size()); i++) {
            System.out.println((i + 1) + ". " + villesDuDpt.get(i));
        }
    }
}
