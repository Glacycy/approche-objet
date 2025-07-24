package fr.diginamic.recensement;

import java.util.*;

public class AffVilleRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.print("Nom de la région : ");
        String nomRegion = scanner.nextLine().trim();

        List<Ville> villesDeLaRegion = new ArrayList<>();
        for (Ville ville : recensement.getVilles()) {
            if (ville.getNomRegion().equalsIgnoreCase(nomRegion)) {
                villesDeLaRegion.add(ville);
            }
        }

        if (villesDeLaRegion.isEmpty()) {
            System.out.println("Aucune ville trouvée pour la région " + nomRegion);
            return;
        }

        villesDeLaRegion.sort((v1, v2) -> Integer.compare(v2.getPopulationTotale(), v1.getPopulationTotale()));

        System.out.println("Les 10 villes les plus peuplées de la région " + nomRegion + " :");
        for (int i = 0; i < Math.min(10, villesDeLaRegion.size()); i++) {
            System.out.println((i + 1) + ". " + villesDeLaRegion.get(i));
        }
    }
}
