package testMoniteur;

import testMoniteur.ProdConsMoniteur;

class Consommateur extends Thread {
	ProdConsMoniteur Mo;

	Consommateur(ProdConsMoniteur Mo) {
		this.Mo = Mo;
	}

	public void run() {
		try {
			while (true) {
				int m = Mo.Prelever();
				Thread.sleep((int) (1000 * Math.random()));
			}
		} catch (InterruptedException e) {
		}
	}
}