package learning_concurence_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Thread2 extends Thread {
    public AtomicInteger i;
    public Thread2( AtomicInteger j ) {
        i=j;
    }
    @Override
    public void run() {
        i.getAndAdd(40);
    }
}
