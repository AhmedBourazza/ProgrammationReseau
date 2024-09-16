package Ex3_similaireA2_Semaphores;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphoreM1 = new Semaphore(1);
        Semaphore semaphoreM2 = new Semaphore(0);
        Semaphore semaphoreM3 = new Semaphore(0);

        Machine1 machine1  = new Machine1(semaphoreM1, semaphoreM2);
        Machine2 machine2 = new Machine2(semaphoreM2, semaphoreM3);
        Machine3 machine3 = new Machine3(semaphoreM3, semaphoreM1);
        machine1.start();
        machine2.start();
        machine3.start();

    }
}
