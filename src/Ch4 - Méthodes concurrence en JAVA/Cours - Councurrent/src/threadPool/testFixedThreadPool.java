package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testFixedThreadPool {
	public static void main(String[] args) {
		int numProcesseur = Runtime.getRuntime().availableProcessors();
		System.out.println("Nombre de processeurs : " + numProcesseur);
		ExecutorService service = Executors.newFixedThreadPool(numProcesseur);
		for (int i = 0; i < 20; i++) {
			service.execute(new Tache(i));
		}
		System.out.println("Le nom de tâche est : "+ Thread.currentThread().getName());
		service.shutdown();
	}
	
	static class Tache implements Runnable{
		private int id;	
		Tache(int id){
			this.id = id;
		}
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("La tâche " + id + " est planifiée avec le thread : "+ Thread.currentThread().getName());
		}
	}

}
