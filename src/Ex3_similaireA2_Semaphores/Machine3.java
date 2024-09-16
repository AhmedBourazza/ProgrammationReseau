package Ex3_similaireA2_Semaphores;

import java.util.concurrent.Semaphore;

public class Machine3 extends Thread {
    Semaphore semaphoreM1, semaphoreM3;

    public Machine3(Semaphore semaphoreM3, Semaphore semaphoreM1) {
        this.semaphoreM1 = semaphoreM1;
        this.semaphoreM3 = semaphoreM3;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                semaphoreM3.acquire();
                System.out.println("Machine 3 a terminé son travail");
                semaphoreM1.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
