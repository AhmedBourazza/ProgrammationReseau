package BlockingQueue.TD;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class writer {
    public int capacite;
    public BlockingQueue<String> queue;
    public writer(int capacite) {
        this.capacite = capacite;
        queue=new ArrayBlockingQueue<>(capacite);
    }
    public void ajouterMessage(Thi t,String message)
    {
        try {
            queue.put(message);
            sleep(1500);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void ajouterMessage(Ths t)
    {
        try {
            if (queue.size()==capacite)
            {
                for (int i=0;i<capacite;i++)
                {
                    String m = queue.take();
                    System.out.println(m);
                }
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
