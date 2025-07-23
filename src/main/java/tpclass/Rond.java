package tpclass;

public class Rond extends Figure implements Surfacable {
//    private Point Point;
    private int z;

    public Rond(Point p1, int z) {
        super(p1);
//        this.Point = Point;
        this.z = z;
    }

    @Override
    public double surface() {
        return Math.PI * z * z;
    }

    //toString [ROND [X;Y], r]
    public String toString() {
        return "[ROND [" + p1.getX() + ";" + p1.getY() + "], " + z + "]";
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{p1};
    }

    //inutile ici car hérité de Figure maintenant
//    public void print() {
//        System.out.println(this);
//    }
}
