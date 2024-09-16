package Ex3_TP_nihad;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Vpark vpark = new Vpark(4);
        for (int i = 0; i < 10; i++) {
            new Voiture(String.valueOf(i),vpark).start();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
