package src;
import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> st= new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		
		st = reverseStack(st);
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}

	private static Stack<Integer> reverseStack(Stack<Integer> st) {
		int ele = st.pop();
		if (!st.empty()) {
			reverseStack(st);
		}
		st.push(ele);
		return st;
	}

}
