package precedenceTaches;

import java.util.concurrent.Semaphore;

class T3 extends Thread {
	private Semaphore[] sems;

	public T3(Semaphore[] sems) {
		this.sems = sems;
		start();
	}


	public void run() {
		try {
			sems[0].acquire();
			System.out.println("D�but de l'ex�cution de T3");
			sleep((int) (Math.random() * 5000));
			System.out.println("Fin de l'ex�cution de T3");
			sems[1].release();
		} catch (Exception e) {

		}
	}
}