package Executor.ConcertSystem;

public class Main {
    public static void main(String[] args) {
        Concert c = new Concert(3);
        for (int i = 0; i < 10; i++) {
            c.reserver(new Commande(1,i));
        }
    }
}
