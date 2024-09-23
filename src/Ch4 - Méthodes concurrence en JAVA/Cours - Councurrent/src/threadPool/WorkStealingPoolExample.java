package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class WorkStealingPoolExample {
    public static void main(String[] args) {
        // Cr�ation d'un Work-Stealing Pool
        ExecutorService executor = Executors.newWorkStealingPool();

        // Soumission de 10 t�ches avec des dur�es d'ex�cution diff�rentes
        for (int i = 0; i < 12; i++) {
            final int taskNumber = i + 1;
            executor.submit(() -> {
                System.out.println("Executing task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    // Simuler des t�ches qui prennent plus ou moins de temps
                    if (taskNumber % 2 == 0) {
                        Thread.sleep(3000); // T�che plus longue
                    } else {
                        Thread.sleep(1000); // T�che plus courte
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskNumber + " completed by " + Thread.currentThread().getName());
            });
        }

        // Fermeture de l'executor
        executor.shutdown();

        try {
            // Attendre la fin de toutes les t�ches avant de quitter
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Timeout occurred before all tasks completed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


