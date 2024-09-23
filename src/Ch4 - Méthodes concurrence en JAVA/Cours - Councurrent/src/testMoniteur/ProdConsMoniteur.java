package testMoniteur;

import java.util.concurrent.locks.*;

class ProdConsMoniteur implements ProdConsInterface {
	final Lock verrou = new ReentrantLock(true	);
	final Condition Plein = verrou.newCondition();
	final Condition Vide = verrou.newCondition();
	int tampon[];
	int queue, tete, N, NbPleins = 0;

	ProdConsMoniteur(int n) {
		N = n;
		tampon = new int[N];
	}

	public void Deposer(int m) throws InterruptedException {
		verrou.lock();
		try {
			if (NbPleins == N)
			{
				System.out.println("Producteur en attente");
				Plein.await();
			}
			tampon[queue] = m;
			queue = (queue + 1) % N;
			NbPleins++;
			//System.out.println(Thread.currentThread().getName() + " vient de produire " + m);
			System.out.println("NbPleins = " + NbPleins);
			Vide.signal();
		} finally {
			verrou.unlock();
		}
	}

	public int Prelever() throws InterruptedException {
		verrou.lock();
		try {
			if (NbPleins == 0)
			{
				System.out.println("Consommateur en attente");
				Vide.await();
			}
			int m = tampon[tete];
			tete = (tete + 1) % N;
			NbPleins--;
			Plein.signal();
			//System.out.println(Thread.currentThread().getName() + " vient de consommer " + m);
			System.out.println("NbPleins = " + NbPleins);
			return m;
		} finally {
			verrou.unlock();
		}
	}
}