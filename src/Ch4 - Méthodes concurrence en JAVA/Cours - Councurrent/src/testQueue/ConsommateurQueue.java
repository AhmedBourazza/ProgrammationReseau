package testQueue;

import java.util.concurrent.BlockingQueue;

public class ConsommateurQueue implements Runnable {

    private final BlockingQueue<Integer> queue;

    @Override
    public void run() {

        try {
            while (true) {
                Integer m = queue.take();
                process(m);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process(Integer m) throws InterruptedException {
        System.out.println("[Consommateur] a prelevé : " + m);
        Thread.sleep(200);
    }

    public ConsommateurQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
}
