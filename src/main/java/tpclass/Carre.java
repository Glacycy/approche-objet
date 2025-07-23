package tpclass;

public class Carre extends Rectangle {

    public Carre(Point p1, int cote) {
        super(p1, cote, cote);
    }

    @Override
    public String getType() {
        return "CARRE";
    }

//    public void affiche(){
//        System.out.println(this);
//    }

    // La méthode equals est héritée de Rectangle
    // Elle fonctionne correctement car elle compare les dimensions
    // Un carré sera égal à un rectangle s'ils ont les mêmes dimensions
    // et le même point de base

    // Pas besoin de redéfinir equals() ici car l'implémentation de Rectangle
    // est suffisante et respecte le principe que "un rectangle peut être égal à un carré"
}
