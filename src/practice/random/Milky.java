package demo;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Milky {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		long test[][] = new long[noOfTestCases][3];
		for (int i = 0; i < noOfTestCases; i++) {
			test[i][0]=s.nextLong();
			test[i][1]=s.nextLong();
			test[i][2]=s.nextLong();

		}
		s.close();
		for (int i = 0; i < test.length; i++) {
			ArrayList<Integer> prime = findPrime(test[i][0]);
			System.out.println(findMagicnumber(prime,(int)test[i][1],(int)test[i][2]));
		}
	}

	private static long findMagicnumber(ArrayList<Integer> prime, int num1, int num2) {
		long magicNos = 0;
		BitSet b =new BitSet((int) num2);
		
		for (int i = num1; i <= num2; i++) {
			if(!b.get(i)){
				for (int p : prime) {
					if(i%p == 0){
						b.set(i);
						for(int j=i+p;j<=num2;j=j+p){
							b.set(j);
						}
						break;
					}
				}
				
			}
			
		}
		for (int i = num1; i <= num2; i++) {
			if(b.get(i)){
				magicNos++;
			}
		}
		return magicNos;
	}

	private static ArrayList<Integer> findPrime(long num) {
		ArrayList<Integer> prime = new ArrayList<>();
		int count=0;
		for (int i = 2; i <= num; i++) {
			count = 0;
			for (long j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					count++;
					break;
				}
			}

			if (count == 0) {
				prime.add(i);
			}

		}
		return prime;

	}
}
