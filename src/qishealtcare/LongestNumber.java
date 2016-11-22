package qishealtcare;

public class LongestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "493284835";
		a.matches("^[0-9]+$");
		mostFrequent(a);
	}
	static void mostFrequent(String sequence) {
		if(sequence.trim().isEmpty() || sequence.length()>100 || !(sequence.matches("^[0-9]+$"))){
			System.out.println("Error");
		}else{
			int a[] = new int[10];
			for (int i = 0; i < sequence.length(); i++) {
				a[Character.getNumericValue(sequence.charAt(i))]++;
			}
			int max = -1;
			int num = -1;
			for (int i = 0; i < a.length; i++) {
				if(a[i] > max){
					max = a[i];
					num = i;
				}
			}
			System.out.println(num);
		}

	}

}
