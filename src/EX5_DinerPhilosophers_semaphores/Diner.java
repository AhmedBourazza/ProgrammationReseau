package EX5_DinerPhilosophers_semaphores;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Diner {
    public ArrayList<Semaphore> fourchettes;
    public int nbrPlat;
    public Diner(int n) {
        nbrPlat=n;
        fourchettes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fourchettes.add(new Semaphore(1));
        }



    }
    public synchronized void eat(Philosophe p) {
        System.out.println("le philosophe " + p.nom+ " mange...");
    }
    public synchronized void penser(Philosophe p) {
        System.out.println("le philosophe " + p.nom+ " pense...");
    }
}
