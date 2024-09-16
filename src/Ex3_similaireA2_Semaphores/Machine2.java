package Ex3_similaireA2_Semaphores;

import java.util.concurrent.Semaphore;

public class Machine2 extends Thread {
    Semaphore semaphoreM2, semaphoreM3;

    public Machine2(Semaphore semaphoreM2, Semaphore semaphoreM3) {
        this.semaphoreM2 = semaphoreM2;
        this.semaphoreM3 = semaphoreM3;
    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                semaphoreM2.acquire();
                System.out.println("Machine 2 a terminé son travail");
                semaphoreM3.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
