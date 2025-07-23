package fr.diginamic.maison;

public class Maison {
    //tableau de type Piece
    private Piece[] pieces = new Piece[0];

    public Maison() {
    }

    public void ajouterPiece(Piece piece) {

        if (piece == null) {
            System.out.println("La pièce est null");
            return;
        }

        if (piece.getSuperficie() < 0 || piece.getNumEtage() < 0) {
            System.out.println("La superficie ou l'étage est < 0");
            return;
        }

        Piece[] newTab = new Piece[this.pieces.length + 1];
        System.arraycopy(this.pieces, 0, newTab, 0, this.pieces.length);
        newTab[newTab.length - 1] = piece;
        this.pieces = newTab;
    }

    public double getSuperficieTotal() {
        double superficieTotal = 0;
        for (Piece piece : this.pieces) {
            superficieTotal += piece.getSuperficie();
        }
        return superficieTotal;
    }

    public double getSuperficieEtage(int etage) {
        double superficieEtage = 0;
        for (Piece piece : this.pieces) {
            if (piece.getNumEtage() == etage) {
                superficieEtage += piece.getSuperficie();
            }
        }
        return superficieEtage;
    }

    //superficie par type de pièce
    public double getSuperficieParType(String typePiece) {
        double superficieType = 0;
        for (Piece piece : this.pieces) {
            if (piece.getClass().getSimpleName().equals(typePiece)) {
                superficieType += piece.getSuperficie();
            }
        }
        return superficieType;
    }

    //nb pièce par type
    public int getNbPiecesParType(String typePiece) {
        int nbPieceType = 0;
        for (Piece piece : this.pieces) {
            if (piece.getClass().getSimpleName().equals(typePiece)) {
                nbPieceType++;
            }
        }
        return nbPieceType;
    }

}
