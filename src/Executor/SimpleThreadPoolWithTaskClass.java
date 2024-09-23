package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Classe représentant une tâche à exécuter
class Task implements Runnable {
    private int taskId;

    // Constructeur pour initialiser l'ID de la tâche
    public Task(int taskId) {
        this.taskId = taskId;
    }

    // Ce qui sera exécuté par chaque thread
    @Override
    public void run() {
        System.out.println("Tâche " + taskId + " exécutée par " + Thread.currentThread().getName());
        try {
            // Simuler une tâche prenant du temps (1 seconde)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tâche " + taskId + " terminée par " + Thread.currentThread().getName());
    }
}

public class SimpleThreadPoolWithTaskClass {
    public static void main(String[] args) {
        // Créer un pool de 3 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // Soumettre 6 instances de la classe Task au pool de threads
        for (int i = 1; i <= 6; i++) {
            Task task = new Task(i);  // Créer une nouvelle tâche avec un ID unique
            threadPool.submit(task);  // Soumettre la tâche au pool
        }

        // Fermer le pool une fois que toutes les tâches sont soumises
        threadPool.shutdown();
    }
}
