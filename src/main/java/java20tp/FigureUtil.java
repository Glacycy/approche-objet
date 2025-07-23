package java20tp;

import java.io.*;
import java.util.*;

public class FigureUtil {
    private static HashMap<String, Figure> figures;

    private static Point getRandomPoint() throws DessinHorsLimiteException {
        Random rand = new Random();
        return new Point(rand.nextInt(98), rand.nextInt(98));
    }

    private static Couleur getRandomCouleur(Random rand) throws DessinHorsLimiteException {
        Couleur[] c = Couleur.values();
        return c[rand.nextInt(c.length)];
    }

    public static Rond getRandomRond() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Rond(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())), getRandomCouleur(rand));
    }

    public static Rectangle getRandomRectangle() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Rectangle(p, rand.nextInt(100 - p.getX()), rand.nextInt(100 - p.getY()), getRandomCouleur(rand));
    }

    public static Carre getRandomCarre() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new Carre(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())), getRandomCouleur(rand));
    }

    public static CarreHerite getRandomCarreHerite() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        return new CarreHerite(p, rand.nextInt(100 - Math.max(p.getX(), p.getY())), getRandomCouleur(rand));
    }

    public static Segment getRandomSegment() throws DessinHorsLimiteException {
        Random rand = new Random();
        Point p = getRandomPoint();
        boolean h = rand.nextBoolean();
        return new Segment(p, (h ?  rand.nextInt(100 - p.getX()) : rand.nextInt(100 - p.getY())), h, getRandomCouleur(rand));
    }

    public static Figure getRandomFigure() throws DessinHorsLimiteException {
        Random rand = new Random();
        return switch (rand.nextInt(5)) {
            case 0 -> getRandomCarre();
            case 1 -> getRandomCarreHerite();
            case 2 -> getRandomRectangle();
            case 3 -> getRandomRond();
            default -> getRandomSegment();
        };
    }

    public static Surfacable getRandomSurfacable() throws DessinHorsLimiteException {
        Random rand = new Random();
        return switch (rand.nextInt(4)) {
            case 0 -> getRandomCarre();
            case 1 -> getRandomCarreHerite();
            case 2 -> getRandomRectangle();
            default -> getRandomRond();
        };
    }

    public static Collection<Point> getPoints(Collection<Figure> figures) {
        HashSet<Point> points = new HashSet<>();

        for (Figure figure : figures) {
            points.addAll(figure.getPoints());
        }

        return points;
    }

    public static Collection<Figure> genere(int nbFigures) throws DessinHorsLimiteException {
        Collection<Figure> figures = new LinkedHashSet<>(nbFigures);

        for (int i = 0; i < nbFigures; i++) {
            figures.add(getRandomFigure());
        }

        return figures;
    }

    public static Figure getFigureEn(Point p, Dessin d) {
        Iterator<Figure> figures = d.getFigures().iterator();
        while (figures.hasNext()) {
            Figure figure = figures.next();
            if (figure.couvre(p)) {
                figures.remove();
                return figure;
            }
        }
        return null;
    }

    public static void afficheFigureEn(Point p, Dessin d) {
        Figure figure = getFigureEn(p, d);
        if (figure != null) {
            System.out.println("Point " + p + " est dans " + figure);
        } else {
            System.out.println("Point " + p + " n'est dans aucune figure du dessin");
        }
    }

    public static Collection<Figure> trieProcheOrigine(Dessin d) {
//        ArrayList<Figure> list = new ArrayList<>(d.getFigures());
//        Collections.sort(list);
//        return list;
        return new TreeSet<>(d.getFigures());
    }

    public static Collection<Surfacable> trieDominant(Dessin d) {
        ArrayList<Surfacable> list = new ArrayList<>();
        for (Figure figure : d.getFigures()) {
            if (Surfacable.class.isAssignableFrom(figure.getClass())) {
                list.add((Surfacable) figure);
            }
        }
        list.sort(new Comparator<>() {
            @Override
            public int compare(Surfacable o1, Surfacable o2) {
                if (o1.surface() > o2.surface()) {
                    return -1;
                } else if (o1.surface() < o2.surface()) {
                    return 1;
                }
                return 0;
            }
        });
        return list;
    }

    public static Figure createRandomFigure(String key) throws DessinHorsLimiteException {
        Figure figure = getRandomFigure();
        if (figures == null) {
            figures = new HashMap<>();
        }
        figures.put(key, figure);
        return figure;
    }

    public static Figure get(String key) {
        if (figures == null) {
            return null;
        }
        return figures.get(key);
    }

    private static final String SAVE_DIR = "saves";

    private static void createSaveDir(){
        File dir = new File(SAVE_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    private static String getSaveDir(String filename){
        return SAVE_DIR + File.separator + filename;
    }

    public static void save(Dessin d, String filename) throws IOException {
        createSaveDir();
        String dirComplete = getSaveDir(filename);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dirComplete))) {
        bw.write("#Fichier de sauvegarde de dessin\n");
        bw.newLine();
        bw.write("# Format: type x y couleur [paramètres spécifiques]\n");
        bw.newLine();
        bw.newLine();

        for (Figure figure : d.getFigures()) {
            String ligne = convertFigureToText(figure);
            bw.write(ligne);
            bw.newLine();
        }
        }
    }

    public static Dessin charge(String filename) throws IOException, DessinHorsLimiteException {
        String dirComplete = getSaveDir(filename);
        Dessin d = new Dessin();
        try (BufferedReader br = new BufferedReader(new FileReader(dirComplete))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty() || ligne.startsWith("#")) {
                    continue;
                }
                Figure figure = convertTextToFigure(ligne);
                if (figure != null) {
                    d.add(figure);
                }
            }
        }
        return d;
    }

    public static String convertFigureToText(Figure figure) {
        String type = figure.getClass().getSimpleName();
        Point p = figure.initialPoint;
        Couleur c = figure.getCouleur();

        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" ");
        sb.append(p.getX()).append(" ").append(p.getY()).append(" ");
        sb.append(c.name()).append(" ");

        if (figure instanceof Rond rond) {
            int rayon = (int) Math.round(Math.sqrt(rond.surface() /Math.PI));
            sb.append(rayon);
        } else if (figure instanceof Rectangle rect && !(figure instanceof CarreHerite)) {
            int largeur = rect.getPointBasDroit().getX() - p.getX();
            int hauteur = rect.getPointHautGauche().getY() - p.getY();
            sb.append(largeur).append(" ").append(hauteur);
        } else if (figure instanceof Carre carre) {
            int cote = carre.getPointBasDroit().getX() - p.getX();
            sb.append(cote);
        } else if (figure instanceof CarreHerite carreH) {
            int cote = carreH.getPointBasDroit().getX() - p.getX();
            sb.append(cote);
        } else if (figure instanceof Segment seg) {
            //Détermine si horizontale ou verticale et la longueur
            Point fin = seg.getPoints().stream()
                    .filter(point -> !point.equals(p))
                    .findFirst().orElse(p);
            boolean horizontal = fin.getY() == p.getY();
            int longueur = horizontal ? fin.getX() - p.getX() : fin.getY() - p.getY();
            sb.append(longueur).append(" ").append(horizontal);
        }

        return sb.toString();
    }

    private static Figure convertTextToFigure(String ligne) throws DessinHorsLimiteException {
        String[] parts = ligne.trim().split("\\s+");
        if (parts.length < 4) {
            return null;
        }

        String type = parts[0];
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        Couleur couleur = Couleur.valueOf(parts[3]);
        Point point = new Point(x, y);

        switch (type) {
            case "Rond":
                if (parts.length >= 5) {
                    int rayon = Integer.parseInt(parts[4]);
                    return new Rond(point, rayon, couleur);
                }
                break;
            case "Rectangle":
                if (parts.length >= 6) {
                    int largeur = Integer.parseInt(parts[4]);
                    int hauteur = Integer.parseInt(parts[5]);
                    return new Rectangle(point, largeur, hauteur, couleur);
                }
                break;
            case "Carre":
                if (parts.length >= 5) {
                    int cote = Integer.parseInt(parts[4]);
                    return new Carre(point, cote, couleur);
                }
                break;
            case "CarreHerite":
                if (parts.length >= 5) {
                    int cote = Integer.parseInt(parts[4]);
                    return new CarreHerite(point, cote, couleur);
                }
                break;
            case "Segment":
                if (parts.length >= 6) {
                    int longueur = Integer.parseInt(parts[4]);
                    boolean horizontal = Boolean.parseBoolean(parts[5]);
                    return new Segment(point, longueur, horizontal, couleur);
                }
                break;
        }

        return null;
    }

}
