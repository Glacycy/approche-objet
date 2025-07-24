package fr.diginamic.recensement;

import java.util.*;

public class AffDptPlusPeuplees extends MenuService{

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        Map<String, Integer> populationsDepartements = new HashMap<>();

        for (Ville ville : recensement.getVilles()) {
            String codeDept = ville.getCodeDepartement();
            populationsDepartements.put(codeDept,
                    populationsDepartements.getOrDefault(codeDept, 0) + ville.getPopulationTotale());
        }

        List<Departement> departements = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : populationsDepartements.entrySet()) {
            departements.add(new Departement(entry.getKey(), entry.getValue()));
        }

        departements.sort((d1, d2) -> Integer.compare(d2.getPopulationTotale(), d1.getPopulationTotale()));

        System.out.println("Les 10 départements les plus peuplés :");
        for (int i = 0; i < Math.min(10, departements.size()); i++) {
            System.out.println((i + 1) + ". " + departements.get(i));
        }
    }

}
