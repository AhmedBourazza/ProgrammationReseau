package precedenceTaches;

import java.util.concurrent.Semaphore;

class T1 extends Thread {
	private Semaphore[] sems;

	public T1(Semaphore[] sems) {
		this.sems = sems;
		start();
	}

	public void run() {
		System.out.println("Début de l'exécution de T1");
		try {
			sleep((int) (Math.random() * 5000));
		} catch (Exception e) {
		}
		System.out.println("Fin de l'exécution de T1");
		sems[0].release();
		sems[0].release();
		sems[0].release();
	}
}