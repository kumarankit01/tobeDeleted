package string.algorithm;

import java.util.Scanner;

public class RichieRich {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String number = in.next();
		boolean[] check_change = new boolean[n];
		char num[] = new char[n];
		for(int i = 0;i < n; i++){
			num[i] = number.charAt(i);
		}
		String palindrome = ChangeToLargestPalindrome(n,k,check_change,num);
		System.out.println(palindrome);
		in.close();
	}

	private static String ChangeToLargestPalindrome(int n, int k, boolean[] check_change, char[] num) {
		// if k>n then we can change all to 9
		if(k >= n){
			String newNum = "";
			for (int i = 0; i < n; i++) {
				newNum +="9";		
			}
			return newNum;
		}

		// code to convert it to palindrome first

		for (int i = 0,j=n-1; i < j; i++,j--) {
			if(num[i] != num[j]){
				if(num[i] < num[j]){
					num[i] = num[j];
				}else{
					num[j] = num[i];
				}
				check_change[i] = true;
				k--;
				if(k < 0){
					return "-1";
				}
			}
		}
		for (int i = 0,j=n-1; i <= j && k>0; i++,j--) {
			if(num[i] != '9'){
				if(check_change[i] && k>=1){
					num[i] = num[j] = '9';
					k--;
				}else if(check_change[i] == false && k>=2){
					num[i] = num[j] = '9';
					k = k-2;
				}else if(i == j && k>=1){
					num[i] = '9';
					k--;
				}

			}
		}
		return String.valueOf(num);
	}

}
