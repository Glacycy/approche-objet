package fr.diginamic.recensement;

import java.util.*;

public class AffRegionsPlusPeuplees extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        Map<String, Integer> populationsRegions = new HashMap<>();

        for (Ville ville : recensement.getVilles()) {
            String nomRegion = ville.getNomRegion();
            populationsRegions.put(nomRegion,
                    populationsRegions.getOrDefault(nomRegion, 0) + ville.getPopulationTotale());
        }
        List<Region> regions = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : populationsRegions.entrySet()) {
            regions.add(new Region(entry.getKey(), entry.getValue()));
        }

        regions.sort((r1, r2) -> Integer.compare(r2.getPopulationTotale(), r1.getPopulationTotale()));

        System.out.println("Les 10 régions les plus peuplées :");
        for (int i = 0; i < Math.min(10, regions.size()); i++) {
            System.out.println((i + 1) + ". " + regions.get(i));
        }
    }
}
