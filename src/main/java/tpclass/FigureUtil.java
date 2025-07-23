package tpclass;

import java.util.Random;

public class FigureUtil {
    private static final Random random = new Random();

    //helper, pour éviter de dupliquer le code
    private static Point getRandomPoint() {
        return new Point(random.nextInt(100), random.nextInt(100)); //entre 0 et 99
    }

    //méthode qui utilise le helper
    //sans le helper, il aurait fallu écrire int x = random.nextInt(100); int y = random.nextInt(100);
    //idem pour le rectangle
    public static Rond getRandomRond() {
        return new Rond(getRandomPoint(), random.nextInt(10) + 1); //entre 1 et 10, le +1 est pour inclure le 10 et éviter le 0
    }

    public static Rectangle getRandomRectangle() {
        return new Rectangle(getRandomPoint(), random.nextInt(10) + 1, random.nextInt(10) + 1);
    }

    public static Carre getRandomCarre() {
        return new Carre(getRandomPoint(), random.nextInt(10) + 1);
    }

    public static Segment getRandomSegment() {
        return new Segment(getRandomPoint(), random.nextInt(10) + 1, random.nextBoolean());
    }

    public static Figure getRandomFigure() {
        int type = random.nextInt(4);
        return switch (type) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarre();
            case 3 -> getRandomSegment();
            default -> throw new IllegalStateException("Type de figure invalide: " + type);
        };
    }

    public static Surfacable getRandomSurfacable() {
        int type = random.nextInt(3);
        return switch (type) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarre();
            default -> throw new IllegalStateException("Type de figure surfaçable invalide: " + type);
        };
    }

    public static Point[] getPoints(Figure... figures) {
        int totalPoints = 0;
        for (Figure figure : figures) {
            totalPoints += figure.getPoints().length;
        }

        Point[] allPoints = new Point[totalPoints];

        int index = 0;
        for (Figure figure : figures) {
            Point[] figurePoints = figure.getPoints();
            for (Point point : figurePoints) {
                allPoints[index] = point;
                index++;
            }
        }

        return allPoints;
    }
}