package entites2;

import entites.AdressePostale; //import de la classe AdressePostale

public class Personne {
    //attributs
    //public pour y accéder de l'extérieur
    public String nom;
    public String prenom;
    public AdressePostale adresse;

    //surcharge constructeur
    public Personne(String nom, String prenom, AdressePostale adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
}
