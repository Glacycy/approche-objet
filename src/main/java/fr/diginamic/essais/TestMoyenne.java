package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {
     public static void main(String[] args) {
         CalculMoyenne c1 = new CalculMoyenne();
         c1.ajout(1.0);
         c1.ajout(2.7);
         c1.ajout(3.0);
         c1.ajout(4.3);
         c1.ajout(5.0);
         System.out.println("Moyenne : " + c1.calcul());

         CalculMoyenne c2 = new CalculMoyenne();
         c2.ajout(10.0);
         c2.ajout(22.6);
         c2.ajout(35.0);
         System.out.println("Moyenne : " + c2.calcul());
     }
}
