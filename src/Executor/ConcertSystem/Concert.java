package Executor.ConcertSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Concert {
    public int nbrPlaces;
    ExecutorService executorService;
    public Concert(int nbrPlaces) {
        executorService= Executors.newFixedThreadPool(3);
        this.nbrPlaces = nbrPlaces;
    }
    public synchronized  void reserver(Commande c)
    {
        if(c.numRes<=nbrPlaces)
        {
            executorService.submit(c);
            nbrPlaces=nbrPlaces-c.numRes;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            System.out.println("Échec de la réservation de "+c.numRes+" billets pour la demande "+c.numeroCommande);
        }
    }
}
