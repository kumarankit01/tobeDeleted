/**

The task is to find the length of the longest subsequence in a given array of integers
 such that all elements of the subsequence are sorted in ascending order. 
 For example, the length of the LIS for { 15, 27, 14, 38, 26, 55, 46, 65, 85 } 
 is 6 and the longest increasing subsequence is {15, 27, 38, 55, 65, 85}.
 * 
 */
package practice.arrays;

import java.util.Scanner;

/**
 * @author kuankit
 *
 */
public class LongestSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = s.nextInt();
		}
		s.close();
		printLongestSubsequence(a);
	}

	private static void printLongestSubsequence(int[] a) {
		int len = 0;
		int parent[] = new int[a.length];
		int temp[] = new int[a.length];
		
		//start itterating over main array
		for (int i = 0; i < a.length; i++) {
			//first element goes directly into the temp array with parent as -1
			if(len == 0){
				temp[len] = i;
				parent[i] = -1;
				len++;
			}
			//if greater then add at the end
			else if(a[i] > a[temp[len - 1]]){
				temp[len] = i;
				parent[i] = temp[len-1];
				len++;
			}else{
				//find the right position
				int low = getIndexToAddI(a, len, temp, i);
				temp[low] = i;
				parent[i] = (low-1 == -1) ? -1:temp[low-1];
			}
		}
		System.out.println("longest seq = "+len);
		int pos = temp[len - 1];
		for (int i = len; i > 0; i--) {
			System.out.println(a[pos]);
			pos = parent[pos];
		}
	}

	private static int getIndexToAddI(int[] a, int len, int[] temp, int i) {
		int low = 0,high = len-1;
		while(low <= high){
			int mid = (int) (Math.ceil(low+high)/2);
			//if we dont check >= then we will get repeated values {1,2,6,2,5,2,7}
			if(a[temp[mid]] >= a[i]){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
			
		}
		return low;
	}

}
