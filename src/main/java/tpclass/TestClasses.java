package tpclass;

import java.util.Arrays;

public class TestClasses {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Rond r = new Rond(p1, 5);
        Rectangle rect = new Rectangle(p1, 4, 5);
        Carre carre = new Carre(p1, 5);
        Segment s = new Segment(p1, 10, true);

        Figure f1 = new Rectangle(new Point(1, 2), 4, 5);
        Figure f2 = new Rond(new Point(3, 4), 2);
        Figure f3 = new Carre(new Point(5, 6), 3);
        Figure f4 = new Segment(new Point(7, 8), 9, false);


        System.out.println("Cercle : " + r);
        System.out.println("Rectangle : " + rect);

        Point defaultPoint = new Point();
        System.out.println("Point par défaut: " + defaultPoint);

        System.out.println("Cercle aléatoire: " + FigureUtil.getRandomRond());
        System.out.println("Rectangle aléatoire: " + FigureUtil.getRandomRectangle());

        System.out.println("===================================");
        System.out.println("Carré : " + carre);
//        System.out.print("Carré avec affiche() : ");
//        carre.affiche();
        System.out.println("Carré aléatoire: " + FigureUtil.getRandomCarre());

        System.out.println("===================================");
        Point p2 = new Point(1, 2);
        System.out.println("p1.equals(p2) : " + p1.equals(p2));

        Rectangle rect2 = new Rectangle(p1, 4, 5);
        System.out.println("rect.equals(rect2) : " + rect.equals(rect2));

        Carre carre2 = new Carre(p1, 5);
        System.out.println("carre.equals(carre2) : " + carre.equals(carre2));

        Rectangle rectCarre = new Rectangle(new Point(0, 0), 5, 5);
        Carre carreRect = new Carre(new Point(0, 0), 5);
        System.out.println("rectCarre.equals(carreRect) : " + rectCarre.equals(carreRect));
        System.out.println("carreRect.equals(rectCarre) = " + carreRect.equals(rectCarre));

        System.out.println("===================================");
        f1.print();
        f2.print();
        f3.print();
        System.out.println("figure aléatoire : ");
        Figure random = FigureUtil.getRandomFigure();
        assert random != null;
        random.print();

        if (random instanceof Surfacable) {
            System.out.println("Surface de la figure aléatoire: " + ((Surfacable) random).surface());
        } else {
            System.out.println("La figure aléatoire n'est pas surfaçable (probablement un Segment)");
        }

        System.out.println("===================================");
        System.out.println("Segment : " + s);

        System.out.println("Surface du cercle : " + r.surface());
        System.out.println("Surface du rectangle : " + rect.surface());
        System.out.println("Surface du carré : " + carre.surface());

        System.out.println("Segment aléatoire: " + FigureUtil.getRandomSegment());

        System.out.println("Surface aléatoire de 3 figures surfacables :");
        for (int i = 0; i < 3; i++) {
            Surfacable surf = FigureUtil.getRandomSurfacable();
            System.out.println("Figure surfaçable " + (i+1) + ": " + s + " - Surface: " + surf.surface());
        }


        System.out.println("===================================");
        System.out.println("Points de 3 figures :");
        for (int i = 0; i < 3; i++) {
            Figure fig = FigureUtil.getRandomFigure();
            System.out.println("Figure " + (i+1) + ": " + fig + " - Points: " + Arrays.toString(fig.getPoints()));
        }
    }
}