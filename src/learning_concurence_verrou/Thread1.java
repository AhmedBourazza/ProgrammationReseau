package learning_concurence_verrou;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread1 extends Thread{
    SharedData s;
    Lock lock ;
    public Thread1(SharedData s, Lock lock){
        this.s = s;
        this.lock = lock;

    }
    public void run(){
       lock.lock();
        try {
            s.i++;
            System.out.println("valeur : "+s.i);
        }finally {
            lock.unlock();
        }


    }
}
