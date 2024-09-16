package Ex4_Cuisine;

import static java.lang.Thread.sleep;

public class Plat {
    public String nom;
    public Plat(String nom) {
        this.nom = nom;
    }
    public void preparer()
    {
        System.out.println("[Station de cuisson 1] pour le plat " + nom);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("[Station de cuisson 2] pour le plat " + nom);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("[Station de cuisson 3] pour le plat " + nom);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
