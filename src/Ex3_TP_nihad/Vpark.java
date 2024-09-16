package Ex3_TP_nihad;

import java.util.concurrent.Semaphore;

public class Vpark {
    public int capacite;
    public Semaphore semaphore;
    public Vpark(int capacite) {
        this.capacite = capacite;
        this.semaphore = new Semaphore(capacite);
    }
    public void arriver(Voiture voiture)
    {
        try {
            System.out.println("Voiture " + voiture.nom + " essaye de trouver une place");

            semaphore.acquire();
            System.out.println("La voiture " + voiture.nom + " est arrivée. place disponible : "+semaphore.availablePermits());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void partir(Voiture voiture) {
        semaphore.release();
        System.out.println("La voiture " + voiture.nom + " est partie.");

    }
}
