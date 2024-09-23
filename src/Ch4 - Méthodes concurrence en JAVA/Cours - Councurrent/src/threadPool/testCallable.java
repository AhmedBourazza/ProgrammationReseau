package threadPool;

import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.*;

public class testCallable {
	public static void main(String[] args) throws Exception{
		int numProcesseur = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(numProcesseur);
		
		List<Future> listFuture = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Future<Integer> future = service.submit(new Tache());
			listFuture.add(future);
		}
		// effectuer d'autres opérations
		System.out.println("Nous allons effectuer d'autres opérations");
		Thread.sleep(5000);

		for (int i = 0; i < 100; i++) {
			Future<Integer> future = listFuture.get(i);
			try {
				//Integer res = future.get(1, TimeUnit.SECONDS); // opération bloquante ---> time out
				Integer res = future.get(1, TimeUnit.MILLISECONDS); // opération bloquante ---> time out
				System.out.println("Le résultat de tâche "+ i + " est : " + res);
			} catch (TimeoutException e) {
				System.out.println("La tâche "+ i + " a pris beaucoup de temps");
			} 
		}
		//  
		System.out.println("Le nom de tâche est : "+ Thread.currentThread().getName());
		service.shutdown();
	}
	
	
	static class Tache implements Callable<Integer>{
		public Integer call() throws Exception {
			Thread.sleep(250);
			return new Random().nextInt();
		}
	}

}





