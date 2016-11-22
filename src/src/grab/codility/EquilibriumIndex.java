package grab.codility;

public class EquilibriumIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,1};
		System.out.println(solution(a));

	}
	  public static int solution(int[] A) {
	        int sum[] = new int[A.length+2];
	        for (int i = 1; i <= A.length; i++) {
				sum[i] = sum[i-1]+A[i-1];
			}
	        for (int i = sum.length-2; i>0; i--) {
				if(sum[i+1]==sum[i-1]){
					return i-1;
				}
			}
	        return -1;
	    }
}
