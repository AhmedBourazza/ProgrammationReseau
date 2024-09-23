package testQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class testProdConsQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        new Thread(new testQueue.ProducteurQueue(queue)).start();
        new Thread(new testQueue.ConsommateurQueue(queue)).start();

    }

}
