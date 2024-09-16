package learning_concurence_verrou;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer i = 10;
        SharedData sharedData = new SharedData(i);
        Lock lock = new ReentrantLock();
        /*Thread1 thread1 = new Thread1(sharedData,lock);
       Thread1 thread2 = new Thread1(sharedData,lock);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();*/
        Thread_tryLock thread_tryLock = new Thread_tryLock(sharedData, lock);
        Thread_tryLock thread_lock2 = new Thread_tryLock(sharedData, lock);
        thread_tryLock.start();
        thread_lock2.start();
        thread_tryLock.join();
        thread_lock2.join();
        System.out.println(sharedData.i);
    }
}
