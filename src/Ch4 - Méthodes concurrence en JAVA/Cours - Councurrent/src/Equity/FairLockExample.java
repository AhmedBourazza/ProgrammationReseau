package Equity;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private static final int NUM_THREADS = 5;
    private static final ReentrantLock fairLock = new ReentrantLock(true); // Verrou équitable

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUM_THREADS];

        // Création des threads
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Worker(fairLock), "Thread-" + (i + 1));
            threads[i].start();
        }

        // Attendre la fin de tous les threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Worker implements Runnable {
        private final ReentrantLock lock;

        Worker(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) { // Chaque thread essaie de verrouiller 5 fois
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " a obtenu le verrou.");
                    // Simuler un travail
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " libère le verrou.");
                    lock.unlock();
                }
            }
        }
    }
}
