package practice.random;

import java.util.Scanner;

public class walmart1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		s.close();
		double friends_combination = Math.pow(2, N) - 1 ;
		
		double frame_needed = Math.abs(friends_combination-M);
		System.out.println(frame_needed);
	}

}
