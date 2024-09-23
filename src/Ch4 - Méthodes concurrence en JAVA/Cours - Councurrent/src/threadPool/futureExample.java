package threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class futureExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Soumettre une t�che asynchrone de t�l�chargement de fichier
        Future<String> downloadFuture = executorService.submit(new FileDownloadTask("Test"));

        // Pendant que le fichier est t�l�charg�, on peut effectuer d'autres t�ches
        try {
            // Simuler d'autres t�ches (affichage d'un message d'attente)
            for (int i = 0; i < 5; i++) {
                System.out.println("Le fichier est en cours de t�l�chargement... (" + (i + 1) * 2 + " secondes �coul�es)");
                Thread.sleep(2000); // Attendre 2 secondes
            }

            // Une fois les autres t�ches termin�es, on peut v�rifier si le t�l�chargement est termin�
            if (downloadFuture.isDone()) {
                System.out.println("T�l�chargement termin�. R�sultat : " + downloadFuture.get());
            } else {
                System.out.println("T�l�chargement encore en cours, mais les autres t�ches sont termin�es.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    // Classe impl�mentant Callable pour simuler un t�l�chargement de fichier
    static class FileDownloadTask implements Callable<String> {
        private String fileUrl;

        FileDownloadTask(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        @Override
        public String call() throws Exception {
            // Simuler un temps de t�l�chargement
            Thread.sleep(10000); // Simuler un t�l�chargement qui prend 10 secondes
            return "T�l�chargement r�ussi depuis l'URL : " + fileUrl;
        }
    }
}

