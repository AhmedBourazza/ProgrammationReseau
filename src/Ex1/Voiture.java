package Ex1;

import java.util.Random;

public class Voiture extends Thread{
    private vPark park;
    private String nom;
    public Voiture(vPark park, String nom) {
        this.park = park;
        this.nom = nom;
    }

    public vPark getPark() {
        return park;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        park.arriver(this);
        Random r = new Random();

        try {
            sleep(r.nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        park.partir(this);

    }
}
