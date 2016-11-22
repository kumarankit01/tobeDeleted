package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
	class Producer implements Runnable{
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					queue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class Producer2 implements Runnable{
		@Override
		public void run() {
			for (int i = 10; i < 20; i++) {
				try {
					queue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class Consumer implements Runnable{
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println(queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(20);
		ProducerConsumer pc = new ProducerConsumer();
		
		Consumer c1 = pc.new Consumer();
		Consumer c2 = pc.new Consumer();

		Producer p1 = pc.new Producer();
		Producer p2 = pc.new Producer();

		Producer2 p3 = pc.new Producer2();
		Producer2 p4 = pc.new Producer2();
		
		executor.execute(p1);
		executor.execute(p2);
		executor.execute(p3);
		executor.execute(p4);
		executor.execute(c1);
		executor.execute(c2);
		executor.execute(c1);
		executor.execute(c2);
		executor.shutdown();

	}

}
