package Ex3_similaireA2_Semaphores;

import java.util.concurrent.Semaphore;

public class Machine1 extends Thread {
    Semaphore semaphoreM1, semaphoreM2;

    public Machine1(Semaphore semaphoreM1, Semaphore semaphoreM2) {
        this.semaphoreM1 = semaphoreM1;
        this.semaphoreM2 = semaphoreM2;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                semaphoreM1.acquire();
                System.out.println("Machine 1 a terminé son travail");
                semaphoreM2.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
