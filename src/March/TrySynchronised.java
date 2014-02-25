package March;

public class TrySynchronised {

	public static void main(String args[]) {
		//TrySynchronised t = new TrySynchronised();
		myThread thread = new myThread();
		new Thread(thread,"A").start();
		new Thread(thread,"B").start();
		new Thread(thread,"C").start();
		new Thread(thread,"D").start();
	}

}

class myThread implements Runnable {
	String str = "";
	int num = 100;

	@Override
	public synchronized void run() {
		while (true) {
			synchronized (str) {
				if (num > 0) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.getMessage();
					}
					System.out.println(Thread.currentThread().getName()
							+ "this is " + num--);
				}
			}

		}
	}

}