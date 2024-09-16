package Ex4_TP;

import java.util.concurrent.Semaphore;

public class Bat_Computer {
    public int nbrMaxAlertes;
    public Semaphore semaphorePlacesPleines;//initialement a 0
    public Semaphore semaphorePlacesVides;//initialement a nbrMaxAlertes
    public Semaphore mutex;
    public  Bat_Computer(int nbrMaxAlertes) {
        this.nbrMaxAlertes = nbrMaxAlertes;
        semaphorePlacesPleines= new Semaphore(0);
        semaphorePlacesVides= new Semaphore(nbrMaxAlertes);
        mutex=new Semaphore(1);
    }
    public void ajouterAlerte(Police p)
    {
        try {

            System.out.println("le policier "+p.nom+" veut ajouté une alerte");

            semaphorePlacesVides.acquire();
            mutex.acquire();
            System.out.println("le policier "+p.nom+" a ajouté une alerte, place dispo : "+semaphorePlacesVides.availablePermits());
            mutex.release();
            semaphorePlacesPleines.release();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void SupprimerAlerte(Bat_Family f)
    {
        try {

                System.out.println("la famille de batman "+f.nom+" veut supprimer une alerte ");

                semaphorePlacesPleines.acquire();
                mutex.acquire();
                System.out.println("la famille de batman  "+f.nom+" a supprimé une alerte ");
                mutex.release();
                semaphorePlacesVides.release();



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
