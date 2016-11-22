package demo;

import java.util.Scanner;

public class GoodString {

	public static void main(String[] args) {
		//Scanner
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		String[] testStrings = new String[noOfTestCases];
		for (int i = 0; i < noOfTestCases; i++) {
			testStrings[i] = s.next();
		}
		s.close();
	for (String string : testStrings) {
			findMaxOp(string);
		}

	}

	private static void findMaxOp(String s1) {
		
		int maxOperations = -1;
		int s1_len = s1.length() - 1;
		//case1: when len is less that 2, max operation is -1
		if(s1.length() < 2){
			System.out.println(maxOperations);
		}
		else{
			//case 2: when len is more than 2 and 1st and last char are same, we need 0 operation
			if(s1.charAt(0)==s1.charAt(s1_len)){
				maxOperations++;
				System.out.println(maxOperations);
			}else{
				int maxCheck = s1_len;
				for(int i = 0; i<=maxCheck;i++){
					int last_pos = s1.lastIndexOf(s1.charAt(i));
					//check if the char is present once more at the end 
					if(i != last_pos){
						maxOperations = i + (s1_len-last_pos);
						
						maxCheck = maxCheck<maxOperations?maxCheck:maxOperations;
						maxOperations = maxCheck;
					}
				}
				System.out.println(maxOperations);

			}
		}
	}

}
