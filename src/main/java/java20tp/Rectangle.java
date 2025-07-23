package java20tp;

import java.util.Set;

public class Rectangle extends Figure implements Surfacable {
    private final Point pointHautGauche;
    private final Point pointHautDroit;
    private final Point pointBasDroit;

    public Rectangle(Point initialPoint, int largeur, int hauteur) throws DessinHorsLimiteException {
        this(initialPoint, largeur, hauteur, Couleur.getCouleurDefaut());
    }

    public Rectangle(Point initialPoint, int largeur, int hauteur, Couleur couleur) throws DessinHorsLimiteException {
        super(initialPoint, couleur);
        try {
            pointHautGauche = new Point(initialPoint.getX(), initialPoint.getY() + hauteur);
        } catch (DessinHorsLimiteException e) {
            throw new DessinHorsLimiteException("Impossible de créer le pointHautGauche du rectangle " + e.getMessage());
        }
        pointHautDroit = new Point(initialPoint.getX() + largeur, initialPoint.getY() + hauteur);
        pointBasDroit = new Point(initialPoint.getX() + largeur, initialPoint.getY());
    }

    public Point getpointBasGauche() {
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

    protected String getType() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return super.toString() + " [initialPoint=" + initialPoint + ", pointHautGauche=" + pointHautGauche
                + ", pointHautDroit=" + pointHautDroit + ", pointBasDroit=" + pointBasDroit + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if ((!getClass().isAssignableFrom(o.getClass()) && !o.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(o.getClass())))
            return false;
        if (Carre.class.isAssignableFrom(o.getClass())) {
            Carre r = ((Carre) o);
            return r.getPointHautGauche().equals(pointHautGauche)
                    && r.getPointBasGauche().equals(initialPoint) && r.getPointHautDroit().equals(pointHautDroit);
        } else {
            Rectangle r = ((Rectangle) o);
            return r.pointHautGauche.equals(pointHautGauche)
                    && r.initialPoint.equals(initialPoint) && r.pointHautDroit.equals(pointHautDroit);
        }
    }

    @Override
    public double surface() {
        return (pointHautDroit.getX() - initialPoint.getX()) * (pointHautDroit.getY() - initialPoint.getY());
    }

    @Override
    public Set<Point> getPoints() {
        return Set.of(getpointBasGauche(), getPointHautGauche(), getPointHautDroit(), getPointBasDroit());
    }

    @Override
    public boolean couvre(Point p) {
        return p.getX() >= initialPoint.getX() && p.getX() <= pointHautDroit.getX()
                && p.getY() >= initialPoint.getY() && p.getY() <= pointHautDroit.getY();
    }
}
