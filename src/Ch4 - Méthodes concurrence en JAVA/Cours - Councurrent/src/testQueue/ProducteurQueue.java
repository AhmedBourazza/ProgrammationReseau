package testQueue;

import java.util.concurrent.BlockingQueue;

public class ProducteurQueue implements Runnable {

    private final BlockingQueue<Integer> queue;

    @Override
    public void run() {

        try {
            process();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process() throws InterruptedException {

        // Put 20 elements into Queue
        for (int m = 0; m < 20; m++) {
            queue.put(m);
            System.out.println("[Producteur] vient de produire : " + m + " , il reste " + queue.remainingCapacity() + " places dans la queue");
            Thread.sleep(100);
        }

    }

    public ProducteurQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
}
