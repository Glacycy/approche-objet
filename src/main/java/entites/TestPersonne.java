package entites;

import entites2.Personne;

public class TestPersonne {
    public static void main(String[] args) {

        //création adresse 1er personne
        AdressePostale adresse1 = new AdressePostale();
        adresse1.numeroRue = 15;
        adresse1.libelleRue = "rue de la paix";
        adresse1.codePostal = 69000;
        adresse1.ville = "Lyon";

        //création personne 1er personne
        Personne personne1 = new Personne();
        personne1.nom = "Dupont";
        personne1.prenom = "Jean";
        personne1.adresse = adresse1;

        //création deuxième personne
        Personne personne2 = new Personne();
        personne2.nom = "Dupont";
        personne2.prenom = "Jean";
        //création direct pour la deuxième personne
        personne2.adresse = new AdressePostale();
        personne2.adresse.numeroRue = 7;
        personne2.adresse.libelleRue = "bd ST Germain";
        personne2.adresse.codePostal = 34000;
        personne2.adresse.ville = "Montpellier";

    }
}
