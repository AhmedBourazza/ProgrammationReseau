package Ex4_TP;

public class Bat_Family extends Thread {
    public String nom;
    Bat_Computer batComputer;
    public Bat_Family(String nom, Bat_Computer batComputer)
    {
        this.nom = nom;
        this.batComputer = batComputer;
    }

    @Override
    public void run() {
        batComputer.SupprimerAlerte(this);
    }
}
