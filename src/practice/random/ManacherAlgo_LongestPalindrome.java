package core;

public class ManacherAlgo_LongestPalindrome {

	public static void main(String[] args) {
		String s1_odd = "abababa";
		String s2_even = "abaaba";
		String s3 = "ccd";
		String s4 = "aba";
		String s5 = "abcdertyui";
		String modified = transform(s2_even);
		printLongestPalindrome(s2_even,modified);
		
		modified = transform(s1_odd);
		printLongestPalindrome(s1_odd,modified);
		
		modified = transform(s3);
		printLongestPalindrome(s3,modified);
		
		modified = transform(s4);
		printLongestPalindrome(s4,modified);
		
		modified = transform(s5);
		printLongestPalindrome(s5,modified);
	}

	private static void printLongestPalindrome(String s1_odd, String s1_m) {
		int c = 0,r = 0,mirror = 0;
		int p[] = new int[s1_m.length()];
		
		for(int i = 1; i< s1_m.length()-1;i++){
			//check if i is within right boundary
			// mirror = c - (i - c)
			
			if(i < r){
				mirror = (2*c) - i;
				p[i] = Math.min(r - i, p[mirror]);
			}
			
			//start matching beyond what is already confirmed by mirror
			while(s1_m.charAt(i+1+p[i]) == s1_m.charAt(i - (1+p[i]))){
				p[i]++;
			}
			// check if new palindrome has crossed right boundary
			if(p[i] +i > r){
				r = p[i] + i;
				c = i;
			}
		}
		for (int i = 0; i < p.length; i++)
			System.out.print(p[i]);
		System.out.println();
		System.out.println("longest palin = "+longestPalindromicSubstring(p,s1_odd));
	}
	public static String longestPalindromicSubstring(int[] p, String s) {
		int length = 0;
		int center = 0;
		for (int i = 1; i < p.length-1; i++) {
			if (p[i] > length) {
				length = p[i];
				center = i;
			}
		}
		  return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);

	}
	private static String transform(String s1_odd) {
		String temp="$";
		for (int i = 0; i < s1_odd.length(); i++) {
			temp = temp+"#"+s1_odd.charAt(i);
		}
		temp = temp+"#@";
		System.out.println("modified String = "+temp);
		return temp;
	}

}
