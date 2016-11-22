package demo;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		int tests[][] = new int[testCases][]; 
		for (int i = 0; i < testCases; i++) {
			int numberOfBricks = scanner.nextInt();
			tests[i] = new int[numberOfBricks];
			for (int j = 0; j < numberOfBricks; j++) {
				tests[i][j] = scanner.nextInt();
			}
		}

		scanner.close();
		for (int i = 0; i < tests.length; i++) {
			int max = getMaxScore(tests[i],0);
			System.out.println(max);
		}

	}

	private static int getMaxScore(int[] brics,int numberOfBricsScanned) {
		if(numberOfBricsScanned > brics.length-1 ){
			return 0;
		}
		int bricsLeft = brics.length - numberOfBricsScanned;
		if(bricsLeft <=3 ){
			int sum = 0;
			for (int i = numberOfBricsScanned ; i < brics.length; i++) {
				sum = sum + brics[i];
			}
			/*for (int i : brics) {
				sum = sum + i;
			}*/
			return sum;
		}else{
			//case 1 : we take top 3 brics
			int sum1 = brics[numberOfBricsScanned] + brics[numberOfBricsScanned+1] + brics[numberOfBricsScanned+2];
			//case2 :we take top 2 (0 and 1) and 5
			int sum3 = brics[numberOfBricsScanned] + brics[numberOfBricsScanned+1] + getMaxScore(brics, numberOfBricsScanned+2+3);
			//case3 : we take 1 (0) and 4 and 5
			int sum2= brics[numberOfBricsScanned]+getMaxScore(brics, numberOfBricsScanned+1+3);
			return Math.max(sum1,  Math.max(sum2, sum3));
		}
	}
}