package tpclass;

public class Segment extends Figure{
    private int lg;
    private boolean horizontal;

    public Segment(Point p1, int lg, boolean horizontal) {
        super(p1);
        this.lg = lg;
        this.horizontal = horizontal;
    }

    public Point getPointFin() {
        if (horizontal) {
            return new Point(p1.getX(), p1.getY() + lg);
        } else {
            return new Point(p1.getX() + lg, p1.getY());
        }
    }

    @Override
    public String toString() {
        return "[SEGMENT " + p1 + " à " + getPointFin() + "]";
    }

    @Override
    public Point[] getPoints() {
        return new Point[]{p1, getPointFin()};
    }
}
