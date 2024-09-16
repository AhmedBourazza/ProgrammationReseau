package learning_concurence_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread1 extends Thread {
    public AtomicInteger i;
    public Thread1( AtomicInteger j ) {
        i=j;
    }
    @Override
    public void run() {
        i.getAndAdd(5);
     }
}
