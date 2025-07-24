package fr.diginamic.recensement;

import java.text.Normalizer;

public class Utils {

    public static String normaliser(String chaine) {
        if (chaine == null) return "";

        String decomposee = Normalizer.normalize(chaine, Normalizer.Form.NFD);

        String noAccents = decomposee.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        return noAccents.toLowerCase().trim();
    }
}
