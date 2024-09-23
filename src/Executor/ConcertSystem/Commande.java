package Executor.ConcertSystem;

public class Commande implements Runnable {
    public int numRes;
    public int numeroCommande;
    public Commande(int numRes, int numeroCommande) {
        this.numRes = numRes;
        this.numeroCommande = numeroCommande;
    }
    @Override
    public void run() {
        int tempsDeTraitement = (int) (Math.random() * 3000) + 1000;
        try {
            Thread.sleep(tempsDeTraitement);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Reservation num: " + numeroCommande + " acceptée");
    }
}
