package learning_concurence_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleCallableExample {
    public static void main(String[] args) {
        // Crée un ExecutorService avec un seul thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Crée une tâche Callable qui calcule la somme de deux nombres
        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() {
                int a = 5;
                int b = 10;
                return a + b; // Retourne la somme de 5 et 10
            }
        };

        // Soumettre la tâche au service et obtenir un Future
        Future<Integer> future = executor.submit(sumTask);

        try {
            // Récupérer le résultat de la tâche
            Integer result = future.get(); // Bloque jusqu'à ce que le résultat soit disponible
            System.out.println("La somme est : " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Arrêter le service
            executor.shutdown();
        }
    }
}
