package greab.lendingkart;

import java.util.Stack;

public class BalancedParenthensies {
	private static final String NO= "NO";
	private static final String YES= "YES";

	public static void main(String args[]) {

		System.out.println(balancedParenthensies("{(a,b)}"));
		System.out.println(balancedParenthensies("{(a},b)"));
		System.out.println(balancedParenthensies("()("));
	}

	public static  String balancedParenthensies(String s) {

		Stack<Character> stack  = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '[' || c == '(' || c == '{' ) {
			
				stack.push(c);

			}else if(c == ']') {
				if(stack.isEmpty()) return NO;
				if(stack.pop() != '[') return NO;

			}else if(c == ')') {
				if(stack.isEmpty()) return NO;
				if(stack.pop() != '(') return NO;

			}else if(c == '}') {
				if(stack.isEmpty()) return NO;
				if(stack.pop() != '{') return NO;
			}

		}
		if(stack.isEmpty())
			return YES;
		else
			return NO;
	}
}