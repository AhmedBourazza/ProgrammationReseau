package EX2_Semaphores;

import java.util.concurrent.Semaphore;

public class ThreadC extends Thread {
    int N;
    Semaphore semaphoreC,semaphoreA;
    public ThreadC( int N, Semaphore semaphoreC, Semaphore semaphoreA ) {
        this.N = N;
        this.semaphoreC = semaphoreC;
        this.semaphoreA = semaphoreA;
    }
    public void run(){
        for (int i = 0; i < N; i++) {
            try {
                semaphoreC.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("C");
            semaphoreA.release();

        }
    }
}
