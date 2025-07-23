package java20tp;

import java.util.Set;

public class Carre extends Figure implements Surfacable {
    private final Point pointHautGauche;
    private final Point pointHautDroit;
    private final Point pointBasDroit;

    public Carre(Point initialPoint, int cote) throws DessinHorsLimiteException {
        this(initialPoint, cote, Couleur.getCouleurDefaut());
    }

    public Carre(Point initialPoint, int cote, Couleur couleur) throws DessinHorsLimiteException {
        super(initialPoint, couleur);
        pointHautGauche = new Point(initialPoint.getX(), initialPoint.getY() + cote);
        pointHautDroit = new Point(initialPoint.getX() + cote, initialPoint.getY());
        pointBasDroit = new Point(initialPoint.getX() + cote, initialPoint.getY() + cote);
    }

    public Point getPointBasGauche() {
        return initialPoint;
    }

    public Point getPointHautGauche() {
        return pointHautGauche;
    }

    public Point getPointHautDroit() {
        return pointHautDroit;
    }

    public Point getPointBasDroit() {
        return pointBasDroit;
    }

    @Override
    public String toString() {
        return super.toString() + " [initialPoint=" + initialPoint + ", pointHautGauche=" + pointHautGauche
                + ", pointHautDroit=" + pointHautDroit + ", pointBasDroit=" + pointBasDroit + "]";
    }

    @Override
    protected String getType() {
        return "Carré";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if ((!getClass().isAssignableFrom(o.getClass()) && !Rectangle.class.isAssignableFrom(o.getClass())))
            return false;
        if (Rectangle.class.isAssignableFrom(o.getClass())) {
            Rectangle r = ((Rectangle) o);
            return r.getPointBasDroit().equals(pointBasDroit) && r.getPointHautGauche().equals(pointHautGauche)
                    && r.getPointHautDroit().equals(pointHautDroit);
        } else {
            Carre r = ((Carre) o);
            return r.pointBasDroit.equals(pointBasDroit) && r.pointHautGauche.equals(pointHautGauche)
                    && r.pointHautDroit.equals(pointHautDroit);
        }
    }

    @Override
    public double surface() {
        return (pointHautDroit.getX() - initialPoint.getX()) * (pointHautDroit.getY() - initialPoint.getY());
    }

    @Override
    public Set<Point> getPoints() {
        return Set.of(getPointBasGauche(), getPointHautGauche(), getPointHautDroit(), getPointBasDroit());
    }
    @Override
    public boolean couvre(Point p) {
        return p.getX() >= initialPoint.getX() && p.getX() <= pointHautDroit.getX()
                && p.getY() >= initialPoint.getY() && p.getY() <= pointHautDroit.getY();
    }
}
