package precedenceTaches;

import java.util.concurrent.Semaphore;

class T5 extends Thread {
	private Semaphore[] sems;

	public T5(Semaphore[] sems) {
		this.sems = sems;
		start();
	}

	public void run() {
		try {
			sems[1].acquire();
			sems[1].acquire();
			sems[1].acquire();
			System.out.println("Début de l'exécution de T5");
			sleep((int) (Math.random() * 5000));
			System.out.println("Fin de l'exécution de T5");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}