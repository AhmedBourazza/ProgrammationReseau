package EX5_DinerPhilosophers_semaphores;

import java.util.concurrent.Semaphore;

public class Philosophe extends Thread {
    public String nom;
    Diner d;
    public int ordre;
    public Philosophe(Diner d, String nom, int ordre) {
        this.nom = nom;
        this.d = d;
        this.ordre = ordre;
    }

    @Override
    public void run() {
        try {
            d.penser(this);
            d.fourchettes.get(ordre).acquire();
            d.fourchettes.get((ordre+1)%d.nbrPlat).acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        d.eat(this);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        d.fourchettes.get(ordre).release();
        d.fourchettes.get((ordre+1)%d.nbrPlat).release();
    }
}
