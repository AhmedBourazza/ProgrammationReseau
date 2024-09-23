package precedenceTaches;

import java.util.concurrent.Semaphore;

public class precedenceTaches {
	public static void main(String[] args) {
		Semaphore[] sems = new Semaphore[2];
		for (int i = 0; i < 2; i++) {
			sems[i] = new Semaphore(0);
		}
		new T1(sems);
		new T2(sems);
		new T3(sems);
		new T4(sems);
		new T5(sems);

	}

}