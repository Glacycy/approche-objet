package tpclass;

public class Rectangle extends Figure implements Surfacable {
//    private Point p1;
    private int l;
    private int h;

    public Rectangle(Point p1, int l, int h) {
        super(p1);
//        this.p1 = p1;
        this.l = l;
        this.h = h;
    }

    @Override
    public double surface() {
        return l * h;
    }

    //getPointBasGauche()
    public Point getPointBasGauche() {
        return p1;
    }

    //getPointBasDroit()
    public Point getPointBasDroit() {
        return new Point(p1.getX() + l, p1.getY());
    }

    //getPointHautGauche()
    public Point getPointHautGauche() {
        return new Point(p1.getX(), p1.getY() + h);
    }

    //getPointHautDroit()
    public Point getPointHautDroit() {
        return new Point(p1.getX() + l, p1.getY() + h);
    }

    protected String getType(){
        return "RECT";
    }

    //toString [RECT [X;Y][X;Y][X;Y][X;Y]]
    public String toString() {
        return "[" + getType() + " " + p1 + " " + getPointBasDroit() + " " + getPointHautDroit() + " " + getPointHautGauche() + "]";
    }

    @Override
    public Point[] getPoints() {
        return new Point[0];
    }

    //print toString() inutile ici car hérité de Figure maintenant
//    public void print() {
//        System.out.println(toString());
//    }

    public int getL() {
        return l;
    }

    public int getH() {
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        // instanceof gère automatiquement les cas null et les mauvais types, donc pas besoin de vérifications supplémentaires
        if (obj instanceof Rectangle other) {
            return this.p1.equals(other.p1) && this.l == other.l && this.h == other.h;
        }
        return false;
    }

//    @Override
//    public Point[] getPoints() {
//        return new Point[]{
//                getPointBasGauche(),
//                getPointBasDroit(),
//                getPointHautDroit(),
//                getPointHautGauche()
//        };
//    }
}
