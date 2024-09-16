package Exemple_Verrou;

public class CounterSynchronized {
    private int count = 0;

    // Méthode synchronisée pour incrémenter le compteur
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        CounterSynchronized counter = new CounterSynchronized();

        // Création de threads pour incrémenter le compteur
        Thread t1 = new IncrementThreadSynchronized(counter);
        Thread t2 = new IncrementThreadSynchronized(counter);

        // Démarrer les threads
        t1.start();
        t2.start();

        // Attendre que les threads terminent
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Afficher le résultat
        System.out.println("Count: " + counter.getCount()); // Devrait afficher 2000
    }
}

// Classe qui incrémente le compteur
class IncrementThreadSynchronized extends Thread {
    private CounterSynchronized counter;

    public IncrementThreadSynchronized(CounterSynchronized counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
