package Ex1_Semaphores;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class vPark {
    public int capacite;
    Semaphore semaphore;
    Semaphore mutex;

    ArrayList<Voiture> places;
    public vPark(int capacite) {
        this.capacite = capacite;
        this.semaphore = new Semaphore(capacite);
        this.places = new ArrayList<>();
        mutex = new Semaphore(1);
    }

    public  void arriver(Voiture v)
    {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("parking2 la voiture "+v.getNom()+" est arrivée, place disponible = "+semaphore.availablePermits());
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.places.add(v);
        this.afficher();

        mutex.release();
    }
    public  void partir(Voiture v)
    {

        semaphore.release();
        System.out.println("la voiture "+v.getNom()+" est partie, place disponible = "+semaphore.availablePermits());
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.places.remove(v);
        this.afficher();

        mutex.release();

    }
    public synchronized void afficher()
    {
        for(Voiture v : places)
        {
            System.out.print(v.getNom()+" ");
        }
        System.out.println();
    }
}
