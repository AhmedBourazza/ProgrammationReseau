package JavaUtilconcurrent;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicExample {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.getAndAdd(5); // Incrémente de manière atomique
    }

    public int getCounter() {
        return counter.get(); // Récupère la valeur actuelle de manière atomique
    }
}

public class testAtomic {
    public static void main(String[] args) throws InterruptedException {
        AtomicExample atomicExample = new AtomicExample();

        // Créer plusieurs threads qui vont incrémenter le compteur
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                atomicExample.increment();
                System.out.println("Valeur1 : " + atomicExample.getCounter());
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                atomicExample.increment();
                System.out.println("Valeur2 : " + atomicExample.getCounter());
            }
        });

        // Démarrer les threads
        thread1.start();
        thread2.start();

        // Attendre que les threads se terminent
        thread1.join();
        thread2.join();

        // Afficher la valeur finale du compteur
        System.out.println("Valeur finale du compteur : " + atomicExample.getCounter());
    }
}