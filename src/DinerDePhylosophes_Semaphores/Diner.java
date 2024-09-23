package DinerDePhylosophes_Semaphores;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Diner {
    public int nombresPhylosophes;
    public Semaphore[] semaphores;
    public Diner(int nombresPhylosophes){
        this.nombresPhylosophes = nombresPhylosophes;
        semaphores = new Semaphore[nombresPhylosophes];
        for(int i = 0; i < nombresPhylosophes; i++){
            semaphores[i] = new Semaphore(1);
        }
    }
    public void manger(Philosophe p) {
        try {
            System.out.println("Le philosophe " + p.ordre + " attend.");

            // Philosophe pair : prend la fourchette gauche puis droite
            // Philosophe impair : prend la fourchette droite puis gauche
            if (p.ordre % 2 == 0) {
                semaphores[p.ordre].acquire(); // Prendre la fourchette gauche
                semaphores[(p.ordre + 1) % nombresPhylosophes].acquire(); // Prendre la fourchette droite
            } else {
                semaphores[(p.ordre + 1) % nombresPhylosophes].acquire(); // Prendre la fourchette droite
                semaphores[p.ordre].acquire(); // Prendre la fourchette gauche
            }

            System.out.println("Le philosophe " + p.ordre + " mange.");
            sleep(3000);  // Simulation du temps pour manger

            // Relâcher les deux fourchettes
            semaphores[p.ordre].release();
            semaphores[(p.ordre + 1) % nombresPhylosophes].release();

            System.out.println("Le philosophe " + p.ordre + " a fini de manger.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
