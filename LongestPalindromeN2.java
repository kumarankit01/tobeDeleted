package core;

public class LongestPalindromeN2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "banana";
		printLongestPalindrome(temp);

	}

	private static void printLongestPalindrome(String temp) {
		// TODO Auto-generated method stub
		int pal_size=1;
		int pal_startPos = 0;
		int len = temp.length();
		boolean[][] check = new boolean[len-1][len-1];
		for (int i = 0; i < len; i++) {
			check[i][i] = true;
		}
		for (int i = 0; i < len-1; i++) {
			if(temp.charAt(i) == temp.charAt(i+1)){
				check[i][i+1] = true;
				pal_size=2;
				pal_startPos = i;
			}else{
				check[i][i+1] = false;
			}
		}
		for (int i = 2; i < len-1; i++) {
			for (int j = 0; j < len-i+1; j++) {
				if(temp.charAt(j) == temp.charAt(i+j-1) && check[i+1][i-1]){
					check[i][i+j] = true;
					pal_size = j+1;
					pal_startPos = i;
				}
			}
		}

	}

}
