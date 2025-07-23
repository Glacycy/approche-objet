package tpclass;

public abstract class Figure{

    protected Point p1;

    public Figure(Point p1){
        this.p1 = p1;
    }

    //Méthode commune aux classes filles
    public void print(){
        System.out.println(this);
    }

    //méthode abstraite que chaque classe fille doit implémenter
    public abstract String toString();


    public abstract Point[]getPoints();

}
