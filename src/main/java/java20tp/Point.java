package java20tp;

public class Point {
    private static final int INIT_X = 25;
    private static final int INIT_Y = 25;
    private final int x;
    private final int y;

    public Point() throws DessinHorsLimiteException {
        this(INIT_X, INIT_Y);
    }

    public Point(int x, int y) throws DessinHorsLimiteException {
        if (x < 0 || y < 0 || x > 99 || y > 99) {
            throw new DessinHorsLimiteException("X et Y doivent être compris entre 0 et 99");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point p) {
        return Math.abs(Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2)));
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().isAssignableFrom(o.getClass())) return false;
        Point p = ((Point) o);
        return p.x == x && p.y == y;
    }
}
