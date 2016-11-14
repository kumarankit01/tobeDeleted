package core;

public class LongestPalindromeN2 {

	public static void main(String[] args) {
		String temp = "banananabab";
		printLongestPalindrome(temp);

	}

	private static void printLongestPalindrome(String temp) {
		int pal_size=1;
		int pal_startPos = 0;
		int len = temp.length();
		boolean[][] check = new boolean[len][len];
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
		for (int j = 2; j <len; j++) {
			for (int i = 0; i < len-j; i++) {
				if((temp.charAt(i) == temp.charAt(i+j)) && check[i+1][i+j-1]){
					check[i][i+j] = true;
					pal_size = i+j;
					pal_startPos = i;
				}
			}
		}
		System.out.println(temp.substring(pal_startPos,pal_size+1));
	}
}
