package EX2_Semaphores;

import java.util.concurrent.Semaphore;

public class ThreadA extends Thread{
    int N;
    Semaphore semaphoreA,semaphoreB;
    public ThreadA( int N, Semaphore semaphoreA, Semaphore semaphoreB) {
        this.N = N;
        this.semaphoreA = semaphoreA;
        this.semaphoreB = semaphoreB;
    }
    public void run(){
        for (int i = 0; i < N; i++) {
            try {
                semaphoreA.acquire();
                System.out.print("A");
                semaphoreB.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
 }
    }
}
