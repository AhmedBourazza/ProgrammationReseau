package testMoniteur;

import testMoniteur.ProdConsMoniteur;

class Producteur extends Thread {
	ProdConsMoniteur Mo;

	Producteur(ProdConsMoniteur Mo) {
		this.Mo = Mo;
	}

	public void run() {
		try {
			while (true) {
				int m = (int) (1000 * Math.random());
				Mo.Deposer(m);
				Thread.sleep((int) (1000 * Math.random()));
			}
		} catch (InterruptedException e) {
		}
	}
}