package EX2_Semaphores;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public Semaphore semaphoreA,semaphoreB,semaphoreC; ;
    int N;
    public TestSemaphore(int N) {
        this.N = N;
        this.semaphoreA = new Semaphore(1);
        this.semaphoreB = new Semaphore(0);
        this.semaphoreC = new Semaphore(0);


    }
    public void Printer()
    {
        ThreadA threadA = new ThreadA(N,semaphoreA,semaphoreB);
        ThreadB threadB = new ThreadB(N,semaphoreB,semaphoreC);
        ThreadC threadC = new ThreadC(N,semaphoreC,semaphoreA);
        threadA.start();
        threadB.start();
        threadC.start();

    }
}
