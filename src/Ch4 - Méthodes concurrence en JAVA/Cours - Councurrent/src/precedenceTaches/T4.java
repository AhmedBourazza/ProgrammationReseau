package precedenceTaches;

import java.util.concurrent.Semaphore;

class T4 extends Thread {
	private Semaphore[] sems;

	public T4(Semaphore[] sems) {
		this.sems = sems;
		start();
	}

	public void run() {
		try {
			sems[0].acquire();
			System.out.println("D�but de l'ex�cution de T4");
			sleep((int) (Math.random() * 5000));
			System.out.println("Fin d'ex�cution de T4");
			sems[1].release();
		} catch (Exception e) {
		}
	}
}