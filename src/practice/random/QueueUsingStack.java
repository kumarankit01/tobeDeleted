import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			stackNewestOnTop.push(value);
		}

		public T peek() {
			T t = null ;
			if(stackOldestOnTop.size() > 0){
				t = stackOldestOnTop.peek();
			}else{
				int size = stackNewestOnTop.size();
				for (int i = 0; i < size; i++) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
				t = stackOldestOnTop.peek();
			}
			return t;

		}

		public T dequeue() {
			T t = null ;
			if(stackOldestOnTop.size() > 0){
				t = stackOldestOnTop.pop();
			}else{
				int size = stackNewestOnTop.size();
				for (int i = 0; i < size; i++) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
				t = stackOldestOnTop.pop();
			}
			return t;
		}
	}


	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
