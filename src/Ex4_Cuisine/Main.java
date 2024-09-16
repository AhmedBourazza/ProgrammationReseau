package Ex4_Cuisine;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        // Création de la cuisine avec 3 stations de cuisson
        Cuisine cuisine = new Cuisine(3);

        // Création de plats
        Plat plat1 = new Plat("Pâtes à la Carbonara");
        Plat plat2 = new Plat("Pizza Margherita");
        Plat plat3 = new Plat("Risotto aux Champignons");

        // Création et démarrage de chefs pour préparer les plats
        Chef chef1 = new Chef(cuisine, plat1,"Jean");
        Chef chef2 = new Chef(cuisine, plat2,"Marie");
        Chef chef3 = new Chef(cuisine,plat3 ,"Paul" );


        chef1.start();
        chef2.start();
        chef3.start();

    }
    }

