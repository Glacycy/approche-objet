package tpclass;

public class Point {

    private final static int INIT_X = 25;
    private final static int INIT_Y = 25;


    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(INIT_X, INIT_Y); //appelle l'autre constructeur
    }

    //accesseurs x et y
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //méthode toString qui renvoie [X;Y]
    public String toString() {
        return "[" + x + ";" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point other) {
            return this.x == other.x && this.y == other.y;
        }
        return false;
    }
}
