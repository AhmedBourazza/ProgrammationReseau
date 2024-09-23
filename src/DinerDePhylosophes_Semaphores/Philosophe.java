package DinerDePhylosophes_Semaphores;

public class Philosophe extends Thread{
    public int ordre;
    public Diner diner;
    public Philosophe( int ordre, Diner diner) {
        this.ordre = ordre;
        this.diner = diner;
    }

    @Override
    public void run() {
        while (true) {  // Les philosophes pensent et mangent en boucle
            System.out.println("Le philosophe " + ordre + " pense.");
            try {
                sleep(2000); // Temps de réflexion avant de manger
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            diner.manger(this); // Manger
        }    }
}
