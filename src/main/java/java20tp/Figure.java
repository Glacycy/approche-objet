package java20tp;

import java.util.Collection;

public abstract class Figure implements Comparable<Figure> {
    protected Point initialPoint;
    private static final Point origine;
    protected Couleur couleur;

    static {
        try {
            origine = new Point();
        } catch (DessinHorsLimiteException e) {
            throw new RuntimeException(e);
        }
    }

    protected Figure(Point initialPoint, Couleur  couleur) {
        this.initialPoint = initialPoint;
        this.couleur = couleur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Figure)) return false;
        return (initialPoint == ((Figure) o).initialPoint && couleur == ((Figure) o).couleur);
    }

    @Override
    public String toString() {
        return getType() + " " + couleur;
    };

    protected abstract String getType();

    public abstract Collection<Point> getPoints();

    public abstract boolean couvre(Point p);

    public void affiche() {
        System.out.println(this);
    }

    public double distanceOrigine() {
        return origine.distance(initialPoint);
    }

    @Override
    public int compareTo(Figure figure) {
        double d1 = distanceOrigine();
        double d2 = figure.distanceOrigine();
        if (d1 < d2) {
            return -1;
        } else if (d1 > d2) {
            return 1;
        }
        return 0;
    }

    public Couleur getCouleur() {
        return couleur;
    }
}
