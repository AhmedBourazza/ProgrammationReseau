package JavaUtilconcurrent;

import java.util.concurrent.locks.ReentrantLock;

public class testReentrantLock {

    // Classe LockExample
    public static class LockExample {
        private final ReentrantLock lock = new ReentrantLock();
        private int counter = 0;

        public void increment() {
            lock.lock();
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockExample lockExample = new LockExample();

        // Créer plusieurs threads qui vont incrémenter le compteur
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockExample.increment();
                System.out.println("Valeur 1 : " + lockExample.getCounter());
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockExample.increment();
                System.out.println("Valeur 2 : " + lockExample.getCounter());
            }
        });

        // Démarrer les threads
        thread1.start();
        thread2.start();

        // Attendre que les threads se terminent
        thread1.join();
        thread2.join();

        // Afficher la valeur finale du compteur
        System.out.println("Valeur finale du compteur : " + lockExample.getCounter());
    }
}

