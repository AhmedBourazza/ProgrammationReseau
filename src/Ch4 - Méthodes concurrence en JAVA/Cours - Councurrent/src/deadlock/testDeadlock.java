package deadlock;

import java.util.Random;

public class testDeadlock implements Runnable {
	private static final Object R1 = new Object();
	private static final Object R2 = new Object();
	private final Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) {
		Thread t1 = new Thread(new testDeadlock(), "T1");
		Thread t2 = new Thread(new testDeadlock(), "T2");
		t1.start();
		t2.start();
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			boolean b = random.nextBoolean();
			System.out.println(Thread.currentThread().getName() + "-->"+ "Iteration: "+ i + " , b = "+ b);
			if (b) {
				synchronized (R1) {
					System.out.println(Thread.currentThread().getName() + ": Locked R1.");
					synchronized (R2) {
						System.out.println(Thread.currentThread().getName() + ": Locked R2.");
					}
				}
			} else {
				synchronized (R2) {
					System.out.println(Thread.currentThread().getName() + ": Locked R2.");
					synchronized (R1) {
						System.out.println(Thread.currentThread().getName() + ": Locked R1.");
					}
				}
			}
		}
	}
}