package practice.arrays;

public class WaterLogProblem {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,1,2,3,4,5};
		int b[] = {1,2,3,4,5,4,3,2,1};
		int c[] = {6,8,3,4,6,1,3};
		int d[] = {5,4,3,2,1};
		calculateWaterLogged(b);
	}

	private static void calculateWaterLogged(int[] a) {
		int totalCost = 0;
		for (int i = 0; i < a.length;) {
			while(i < a.length-1 && a[i] < a[i+1]){
				i++;
			}
			int current_max =a[i];
			int pos = i;
			int next_max = -1, next_pos = -1;
			boolean same_max =  false;
			for (int j = i+1; j < a.length; j++) {
				if(a[j] > next_max){
					next_max = a[j];
					next_pos = j;
				}
				if(a[j] >= current_max){
					same_max = true;
					break;
				}
			}
			if(next_pos < pos)
				break;
			int cost = 0;
			for (int j = pos+1; j < next_pos; j++) {
				if(same_max){
					cost += current_max - a[j];
				}else{
					cost += next_max - a[j];
				}
			}
			totalCost +=cost;
			i = next_pos;
		}
		System.out.println(totalCost);

	}

}
