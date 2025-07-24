package fr.diginamic.recensement;

import java.util.*;

public class AffVilleFrance extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        List<Ville> toutesLesVilles = new ArrayList<>(recensement.getVilles());

        toutesLesVilles.sort((v1, v2) -> Integer.compare(v2.getPopulationTotale(), v1.getPopulationTotale()));

        System.out.println("Les 10 villes les plus peuplées de France :");
        for (int i = 0; i < Math.min(10, toutesLesVilles.size()); i++) {
            System.out.println((i + 1) + ". " + toutesLesVilles.get(i));
        }
    }
}
