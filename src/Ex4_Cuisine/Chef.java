package Ex4_Cuisine;

import java.util.concurrent.Semaphore;

public class Chef extends Thread {
    Cuisine c;
    Plat p ;
    String nom;
    public Chef(Cuisine c,Plat p,String nom) {
        this.c = c;
        this.p = p;
        this.nom = nom;
    }
    public void run() {
        try {
            c.semaphore.acquire();
            System.out.println("Chef "+ nom+" a commencé de preparer le plat "+p.nom);
            p.preparer();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            c.semaphore.release();

        }

    }
}
