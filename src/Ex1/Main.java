package Ex1;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        vPark park= new vPark(4);
        for (int i = 0; i<20;i++)
        {
            new Voiture(park,String.valueOf(i)).start();
            Random rand = new Random();
            try {
                sleep(rand.nextInt(2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
