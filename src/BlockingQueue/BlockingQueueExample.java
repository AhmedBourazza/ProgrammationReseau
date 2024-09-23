package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int id;

    public Producer(BlockingQueue<Integer> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int value = i + id * 10;
                queue.put(value);
                System.out.println("Producteur " + id + ": Élément " + value + " ajouté à la queue.\n");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int id;

    public Consumer(BlockingQueue<Integer> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Integer value = queue.take();
                System.out.println("Consommateur " + id + ": Élément " + value + " retiré de la queue.\n");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Créer plusieurs producteurs
        for (int i = 0; i < 3; i++) {
            Thread producerThread = new Thread(new Producer(queue, i));
            producerThread.start();
        }

        // Créer plusieurs consommateurs
        for (int i = 0; i < 3; i++) {
            Thread consumerThread = new Thread(new Consumer(queue, i));
            consumerThread.start();
        }
    }
}
