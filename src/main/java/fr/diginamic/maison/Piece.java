package fr.diginamic.maison;

//class mère
public abstract class Piece {

    private double superficie;
    private int numEtage;

    public Piece(double superficie, int numEtage) {
        this.superficie = superficie;
        this.numEtage = numEtage;
    }

    public double getSuperficie(){
        return superficie;
    }

    public int getNumEtage(){
        return numEtage;
    }

}
