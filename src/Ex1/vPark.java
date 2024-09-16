package Ex1;

import java.util.ArrayList;

public class vPark {
    public int capacite,nbrPlacePleine;
    public ArrayList<Voiture> places;
    public vPark(int capacite ) {
        this.capacite = capacite;
        this.nbrPlacePleine = 0;
        places=new ArrayList<>();
    }

    public synchronized void arriver(Voiture v)
    {
        while(nbrPlacePleine>=capacite)
        /*
        Non, on ne peut pas remplacer directement la boucle while par une simple instruction if. Si on utilisait un if, voici ce qui pourrait arriver :

       1- Supposons que le parking est plein, et qu'une voiture (Thread A)
        est en attente dans la méthode wait().
       2- Une autre voiture (Thread B) quitte le parking, appelle notify()
       et réveille Thread A.
       3- Cependant, entre le moment où Thread A est réveillé et le moment
       où il essaie de prendre la place disponible, un autre thread (Thread C)
       pourrait avoir déjà pris la place.
       4- Si Thread A ne revérifie pas la condition après avoir été réveillé,
       il accédera au parking même si celui-ci est à nouveau plein,
       ce qui violerait la logique de synchronisation et pourrait entraîner
        un comportement incorrect (par exemple, plus de voitures que de
        places dans le parking).

         */
        {
            System.out.println("la voiture "+v.getNom()+" en attente, place disponible = "+(capacite-nbrPlacePleine));
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        nbrPlacePleine++;
        places.add(v);
        System.out.println("la voiture "+v.getNom()+" est arrivée, place disponible = "+(capacite-nbrPlacePleine));
        this.afficher();
    }
    public synchronized void partir(Voiture v)
    {
        nbrPlacePleine--;
        places.remove(v);

        System.out.println("la voiture "+v.getNom()+" est partie, place disponible = "+(capacite-nbrPlacePleine));
        this.afficher();

        notifyAll();
    }
    public synchronized void afficher()
    {
        for(Voiture v : places)
        {
            System.out.print(v.getNom()+" ");
        }
        System.out.println();
    }


}
