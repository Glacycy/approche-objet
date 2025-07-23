package java20tp;

public class CarreHerite extends Rectangle {
    public CarreHerite(Point pointHautGauche, int cote) throws DessinHorsLimiteException {
        this(pointHautGauche, cote, Couleur.getCouleurDefaut());
    }

    public CarreHerite(Point pointHautGauche, int cote, Couleur couleur) throws DessinHorsLimiteException {
        super(pointHautGauche, cote, cote, couleur);
    }

    @Override
    protected String getType() {
        return "Carré";
    }
}
