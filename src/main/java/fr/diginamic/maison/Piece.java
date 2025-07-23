package fr.diginamic.maison;

//class mère
public abstract class Piece {

    private int superficie;
    private int numEtage;

    public Piece(int superficie, int numEtage) {
        this.superficie = superficie;
        this.numEtage = numEtage;
    }

    public int getSuperficie(){
        return superficie;
    }

    public int getNumEtage(){
        return numEtage;
    }

}
