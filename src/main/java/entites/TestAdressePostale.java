package entites;

public class TestAdressePostale {
    public static void main(String[] args) {
        //première instance
//        AdressePostale adressePostale1 = new AdressePostale();
//        adressePostale1.numeroRue = 4;
//        adressePostale1.libelleRue = "rue de la paix";
//        adressePostale1.codePostal = 75000;
//        adressePostale1.ville = "Paris";
//
//        //deuxième instance
//        AdressePostale adressePostale2 = new AdressePostale();
//        adressePostale2.numeroRue = 5;
//        adressePostale2.libelleRue = "rue de la paix";
//        adressePostale2.codePostal = 75000;
//        adressePostale2.ville = "Paris";
//
//        System.out.println("Adresse 1 : " + adressePostale1.numeroRue + " " +
//                adressePostale1.libelleRue + " " + adressePostale1.codePostal
//                + " " + adressePostale1.ville);
//
//        System.out.println("Adresse 2 : " + adressePostale2.numeroRue + " " +
//                adressePostale2.libelleRue + " " + adressePostale2.codePostal
//                + " " + adressePostale2.ville);

        //méthode avec constructeur
        AdressePostale adressePostale1 = new AdressePostale(4, "rue de la paix", 75000, "Paris");
        AdressePostale adressePostale2 = new AdressePostale(5, "rue de la paix", 75000, "Paris");

        System.out.println("Adresse 1 : " + adressePostale1.numeroRue + " " +
                adressePostale1.libelleRue + " " + adressePostale1.codePostal
                + " " + adressePostale1.ville);

        System.out.println("Adresse 2 : " + adressePostale2.numeroRue + " " +
                adressePostale2.libelleRue + " " + adressePostale2.codePostal
                + " " + adressePostale2.ville);

    }
}
