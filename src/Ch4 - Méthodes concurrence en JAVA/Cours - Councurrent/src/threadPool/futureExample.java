package threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class futureExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Soumettre une tâche asynchrone de téléchargement de fichier
        Future<String> downloadFuture = executorService.submit(new FileDownloadTask("Test"));

        // Pendant que le fichier est téléchargé, on peut effectuer d'autres tâches
        try {
            // Simuler d'autres tâches (affichage d'un message d'attente)
            for (int i = 0; i < 5; i++) {
                System.out.println("Le fichier est en cours de téléchargement... (" + (i + 1) * 2 + " secondes écoulées)");
                Thread.sleep(2000); // Attendre 2 secondes
            }

            // Une fois les autres tâches terminées, on peut vérifier si le téléchargement est terminé
            if (downloadFuture.isDone()) {
                System.out.println("Téléchargement terminé. Résultat : " + downloadFuture.get());
            } else {
                System.out.println("Téléchargement encore en cours, mais les autres tâches sont terminées.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    // Classe implémentant Callable pour simuler un téléchargement de fichier
    static class FileDownloadTask implements Callable<String> {
        private String fileUrl;

        FileDownloadTask(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        @Override
        public String call() throws Exception {
            // Simuler un temps de téléchargement
            Thread.sleep(10000); // Simuler un téléchargement qui prend 10 secondes
            return "Téléchargement réussi depuis l'URL : " + fileUrl;
        }
    }
}

