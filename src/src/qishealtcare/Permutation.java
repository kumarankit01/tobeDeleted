package qishealtcare;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permutation("", ""));
	}
	static boolean permutation(String s1, String s2) {
		if(s1.length() != s2.length()){
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			if(s2.indexOf(s1.charAt(i))<0){
				return false;
			}
		}
		return true;


    }

}
