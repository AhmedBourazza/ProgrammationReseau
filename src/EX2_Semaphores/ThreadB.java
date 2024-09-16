package EX2_Semaphores;

import java.util.concurrent.Semaphore;

public class ThreadB extends Thread {
    int N;
    Semaphore semaphoreB,semaphoreC;
    public ThreadB( int N, Semaphore semaphoreB, Semaphore semaphoreC ) {
        this.N = N;
        this.semaphoreB = semaphoreB;
        this.semaphoreC = semaphoreC;
    }
    public void run(){
        for (int i = 0; i < N; i++) {
            try {
                semaphoreB.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("B");
            semaphoreC.release();

        }
    }
}
