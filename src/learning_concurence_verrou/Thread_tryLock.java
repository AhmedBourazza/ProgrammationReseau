package learning_concurence_verrou;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Thread_tryLock extends Thread {
    SharedData s;
    Lock lock;

    public Thread_tryLock(SharedData s, Lock lock) {
        this.s = s;
        this.lock = lock;
    }

    @Override
    public void run() {
        boolean verrouTrouve = false;
        try {
            // Tenter d'acquérir le verrou pendant 16 000 microsecondes (16 ms)
            verrouTrouve = lock.tryLock(0, TimeUnit.MICROSECONDS);

            if (verrouTrouve) {
                try {
                    // Section critique
                    s.i++;
                    System.out.println("Thread " + Thread.currentThread().getName() + " a le verrou");
                } finally {
                    // Toujours libérer le verrou si acquis
                    lock.unlock();
                }
            } else {
                System.out.println("Thread " + Thread.currentThread().getName() + " n'a pas le verrou");
            }
        } catch (InterruptedException e) {
            // Restaurer l'état d'interruption du thread
            Thread.currentThread().interrupt();
            System.out.println("Thread " + Thread.currentThread().getName() + " interrompu");
        }
    }
}
