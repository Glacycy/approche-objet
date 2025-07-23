package java20tp;

import java.util.Set;

public class Rond extends Figure implements Surfacable {
    private final int rayon;

    public Rond(Point initialPoint, int rayon) {
        this(initialPoint, rayon, Couleur.getCouleurDefaut());
    }

    public Rond(Point initialPoint, int rayon, Couleur couleur) {
        super(initialPoint, couleur);
        this.rayon = rayon;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if ((!getClass().isAssignableFrom(o.getClass()) && !o.getClass().isAssignableFrom(getClass())))
            return false;
        Rond r = ((Rond) o);
        return r.rayon == rayon;
    }

    @Override
    public String toString() {
        return super.toString() + " [centre=" + initialPoint + ", rayon=" + rayon + "]";
    }

    @Override
    protected String getType() {
        return "Rond";
    }

    @Override
    public double surface() {
        return rayon * rayon * Math.PI;
    }

    @Override
    public Set<Point> getPoints() {
        return Set.of(initialPoint);
    }

    @Override
    public boolean couvre(Point p) {
        int difX = Math.abs(p.getX() - initialPoint.getX());
        int difY = Math.abs(p.getY() - initialPoint.getY());
        return (Math.abs(Math.sqrt((difX*difX) + (difY*difY))) <= rayon);
    }
}
