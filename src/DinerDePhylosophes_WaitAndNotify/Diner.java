package DinerDePhylosophes_WaitAndNotify;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Diner {
    public int nombresPhylosophes;
    public int[] fourchettes;
    public Diner(int nombresPhylosophes){
        this.nombresPhylosophes = nombresPhylosophes;
        fourchettes = new int[nombresPhylosophes];
        for(int i = 0; i < nombresPhylosophes; i++){
            fourchettes[i] = 1;
        }
    }
    public synchronized void manger(Philosophe p) {
        try {
            if(p.ordre%2==0)
            {
                while (fourchettes[p.ordre] == 0 )
                {
                    System.out.println("Le philosophe " + p.ordre + " pense.");
                    wait();
                }
                fourchettes[p.ordre]=0;
                while (fourchettes[(p.ordre+1)%nombresPhylosophes] == 0 )
                {
                    System.out.println("Le philosophe " + p.ordre + " pense.");
                    wait();
                }
                fourchettes[(p.ordre+1)%nombresPhylosophes]=0;
            }
            else {
                while (fourchettes[(p.ordre+1)%nombresPhylosophes] == 0 )
                {
                    System.out.println("Le philosophe " + p.ordre + " pense.");
                    wait();
                }
                fourchettes[(p.ordre+1)%nombresPhylosophes]=0;
                while (fourchettes[p.ordre] == 0 )
                {
                    System.out.println("Le philosophe " + p.ordre + " pense.");
                    wait();
                }
                fourchettes[p.ordre]=0;
            }
            System.out.println("Le philosophe " + p.ordre + " mange.");
            sleep(1000);
            fourchettes[p.ordre]=1;
            fourchettes[(p.ordre+1)%nombresPhylosophes]=1;
            notifyAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
