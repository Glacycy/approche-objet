package entites;

public class AdressePostale {
    //attributs
    int numeroRue;
    String libelleRue;
    int codePostal;
    String ville;

    //constructeur
    public AdressePostale
            (
                    int numeroRue,
                    String libelleRue,
                    int codePostal,
                    String ville
            )
    {
        // this.numeroRue = attribut de la classe
        // numeroRue = paramètre du constructeur
        this.numeroRue = numeroRue;
        this.libelleRue = libelleRue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

}
