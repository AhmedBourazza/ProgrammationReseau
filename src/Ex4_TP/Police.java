package Ex4_TP;

public class Police extends Thread {
    public String nom;
    Bat_Computer batComputer;
    public Police(String nom, Bat_Computer batComputer)
    {
        this.nom = nom;
        this.batComputer = batComputer;
    }

    @Override
    public void run() {
        batComputer.ajouterAlerte(this);
    }
}
