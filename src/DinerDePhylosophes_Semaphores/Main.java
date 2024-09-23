package DinerDePhylosophes_Semaphores;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Diner diner = new Diner(5);
        for (int i = 0; i < 5; i++) {
            new Philosophe(i,diner).start();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
