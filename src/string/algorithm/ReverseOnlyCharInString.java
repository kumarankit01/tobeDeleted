/*
 * Given a string, that contains special character together with alphabets 
 * (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.
 */

package string.algorithm;

public class ReverseOnlyCharInString {

	public static void main(String[] args) {
		reverseChar("");
	}

	private static void reverseChar(String s) {
		int i = 0;
		int j = s.length()-1;
		char[] c = s.toCharArray();
		while(i < j){
			while(i< c.length && !Character.isLetter(c[i]))
				i++;
			while(j >=0 && !Character.isLetter(c[j]))
				j--;
			if(i < j){
				char temp = c[i];
				c[i] = c[j];
				c[j] = temp;
				i++;j--;
			}
		}
		for (int k = 0; k < c.length; k++) {
			System.out.print(c[k]);
		}
	}

}
