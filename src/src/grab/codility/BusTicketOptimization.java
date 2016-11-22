package grab.codility;

public class BusTicketOptimization {

	public static void main(String[] args) {
		int a[] = {1,2,4,5,6,7,8,9};

		int cost = solution(a);
		System.out.println(cost);

	}
	public static int solution(int[] A) {
		int max_cost_30_DayPass = 25;
		int totalCostWhen_7_and_1_dayPass = 0;
		for (int i = 0; i < A.length;) {
			int nextSevenDays = A[i]+6;
			int NumberOfDaysCovered = 0;
			//if with 7 day pass we can cover more than 3 days then go for it.
			while(i < A.length && A[i] <= nextSevenDays ){
				NumberOfDaysCovered++;
				i++;
			}
			if(NumberOfDaysCovered > 3){
				//taking 7 day pass better if more than 3
				totalCostWhen_7_and_1_dayPass = totalCostWhen_7_and_1_dayPass+7;
			}else{
				//taking 1 day pass
				i = i - NumberOfDaysCovered;
				totalCostWhen_7_and_1_dayPass = totalCostWhen_7_and_1_dayPass + 2;
				i++;
			}

		}
		// check if 30 day better or combination of 1 and  7 day pass
		if(max_cost_30_DayPass > totalCostWhen_7_and_1_dayPass)
			return totalCostWhen_7_and_1_dayPass;
		else
			return max_cost_30_DayPass;
	}


}
