package Ex3_TP_nihad;

import java.util.Random;

public class Voiture extends Thread {
    public String nom;
    public Vpark park;
    public Voiture(String nom, Vpark park) {
        this.nom = nom;
        this.park = park;
    }

    @Override
    public void run() {
        Random r = new Random();
        int n = r.nextInt(20000);
        park.arriver(this);
        try {
            sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        park.partir(this);
    }
}
