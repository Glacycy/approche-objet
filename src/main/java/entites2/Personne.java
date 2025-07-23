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

    //tp 03 :
    public void afficherNomPrenom() {
        System.out.println(nom.toUpperCase() + " " + prenom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(AdressePostale adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public AdressePostale getAdresse() {
        return adresse;
    }

}
