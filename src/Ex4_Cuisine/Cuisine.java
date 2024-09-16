package Ex4_Cuisine;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Cuisine {
    Semaphore semaphore;
    int N;
    public Cuisine(int N) {
        this.N = N;
        semaphore = new Semaphore(N);
    }


}
