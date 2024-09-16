package EX5_DinerPhilosophers_semaphores;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Diner d=new Diner(5);
        for (int i = 0; i < 5; i++) {
           new Philosophe(d,String.valueOf(i),i).start();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
