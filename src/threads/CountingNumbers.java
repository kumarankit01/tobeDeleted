package threads;

public class CountingNumbers {
	private int n = 10;
	String LOCK = "lock";
	boolean evenTurn = true;

	class printEven implements Runnable{

		@Override
		public void run() {
			synchronized (LOCK) {
				for (int i = 0; i < n; i=i+2) {
					System.out.println(i);
					evenTurn = false;
					LOCK.notifyAll();
					try {
						while(!evenTurn)
							LOCK.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}
	class printOdd implements Runnable{

		@Override
		public void run() {
			synchronized (LOCK) {
				try {
					for (int i = 1; i < n; i=i+2) {
						while(evenTurn)
							LOCK.wait();
						System.out.println(i);
						evenTurn = true;
						LOCK.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
	public static void main(String[] args) {
		CountingNumbers c = new CountingNumbers();
		printEven pe = c.new printEven();
		printOdd po = c.new printOdd();
		Thread t1 = new Thread(po);
		Thread t2 = new Thread(pe);
		t1.start();
		t2.start();

	}

}
