package fr.diginamic.operations;

public class CalculMoyenne {
    private double[] tab;

    public CalculMoyenne() {
        tab = new double[0];
    }

    public void ajout(double d) {
        double[] newTab = new double[tab.length + 1];
        System.arraycopy(tab, 0, newTab, 0, tab.length);
        newTab[newTab.length - 1] = d;
        tab = newTab;
    }

    public double calcul() {
        if (tab.length == 0) {
            return 0;
        }

        double somme = 0;
        for (double v : tab) {
            somme += v;
        }
        return somme / tab.length;
    }
}
