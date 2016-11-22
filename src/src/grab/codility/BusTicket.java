package grab.codility;

import java.util.Stack;

public class BusTicket {

	private static final int MONTH_PATH_PRICE = 25;
	private static final int SEVEN_DAY_PASS_PRICE = 7;
	private static final int ONE_DAY_TICKET_PRICE = 2;

	public static void main(String[] args) {
		int a[] = {1,2,4,5,6,7,8};
		Stack<Integer> s = new Stack<>(); 
		int cost = solution(0,a,0);
		System.out.println(Math.min(cost, MONTH_PATH_PRICE));
	}

	private static int solution(int i, int[] a, int cost) {
		if(cost > 25 || i >= a.length){
			return cost;
		}
		//when we take 7 day pass
		//calculate the number of days that can be covered
		int maxDays = a[i]+6;
		int daysCovered = 0;
		for (int j = i; j < a.length; j++) {
			if(a[j]<= maxDays){
				daysCovered++;
			}else{
				break;
			}
		}
		return Math.min(solution(i+1, a, cost+ONE_DAY_TICKET_PRICE), solution(i+daysCovered, a, cost+SEVEN_DAY_PASS_PRICE));
	}

}
