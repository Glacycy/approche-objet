package java20tp;

import java.util.Set;

public class Segment extends Figure {
    private final Point finalPoint;

    public Segment(Point initialPoint, int longueur, boolean horizontal) throws DessinHorsLimiteException {
        this(initialPoint, longueur, horizontal, Couleur.getCouleurDefaut());
    }

    public Segment(Point initialPoint, int longueur, boolean horizontal, Couleur couleur) throws DessinHorsLimiteException {
        super(initialPoint, couleur);
        finalPoint = new Point(initialPoint.getX() + (horizontal ? longueur : 0), initialPoint.getY() + (horizontal ? 0 : longueur));
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if ((!getClass().isAssignableFrom(o.getClass()) && !o.getClass().isAssignableFrom(getClass())))
            return false;
        Segment s = ((Segment) o);
        return s.finalPoint.equals(finalPoint);
    }

    @Override
    public String toString() {
        return super.toString() + " [initialPoint=" + initialPoint + ", finalPoint=" + finalPoint + "]";
    }

    @Override
    protected String getType() {
        return "Segment";
    }

    @Override
    public Set<Point> getPoints() {
        return Set.of(initialPoint, finalPoint);
    }

    @Override
    public boolean couvre(Point p) {
        return p.getX() >= initialPoint.getX() && p.getX() <= finalPoint.getX()
                && p.getY() >= initialPoint.getY() && p.getY() <= finalPoint.getY();
    }
}
