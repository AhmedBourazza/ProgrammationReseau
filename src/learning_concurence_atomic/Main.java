package learning_concurence_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(15);
        Thread1 thread1 =new Thread1(atomicInteger);
        Thread2 thread2 =new Thread2(atomicInteger);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(atomicInteger.get());

    }
}
