package Peterson;

import java.util.Random;

public class operationPeterson extends Thread {
	private Compte compte;
	private int id;
	private static boolean[] drapeau = { false, false };
	private static int tour;


	public operationPeterson(int id, Compte compte) {
		this.compte = compte;
		this.id = id;
	}


    private void sectionEntree() {
    	drapeau[id] = true;
        tour = other();
        while (drapeau[other()] && tour == other()) {
        	try {
				Thread.sleep(new Random().nextInt(10));
			} catch (InterruptedException e) {

			}
        }
    }    
 
    private void sectionSortie() {
        drapeau[id] = false;
    } 
	

    private int other() {
        return id == 0 ? 1 : 0;
    }

	
	public void run() {
		while (true) {
			int i = (int) (Math.random() * 10000);
			String nom = getName();
			
			sectionEntree();
			
			//début de Section critique;
			compte.ajouter(i);
			compte.retirer(i);
			//compte.operationNulle(i);
			int solde = compte.getSolde();
			//fin de Section critique;

			sectionSortie();
			
			if (solde != 0) {
				System.out.println("Erreur : " + nom + " vous informe que le solde=" + solde);
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Compte compte = new Compte();
		for (int i = 0; i < 2; i++) {
			operationPeterson operation = new operationPeterson(i, compte);
			operation.start();
		}
	}
}
