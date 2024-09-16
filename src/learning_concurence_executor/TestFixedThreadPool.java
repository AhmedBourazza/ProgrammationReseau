package learning_concurence_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.execute(new Tache());
        }

        // Arrêter le service proprement après avoir soumis toutes les tâches
        service.shutdown();
    }

    static class Tache implements Runnable {
        public void run() {
            System.out.println("Le nom de tâche est : " + Thread.currentThread().getName());
        }
    }
}
