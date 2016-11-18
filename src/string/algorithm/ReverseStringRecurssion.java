package string.algorithm;

public class ReverseStringRecurssion {

	public static void main(String[] args) {
		String s = "kamehameha";
		System.out.println(s);
		String r = reverse(s);
		System.out.println(r);
	}

	private static String reverse(String s) {
		if(s.length() == 0 || s.length() == 1)
			return s;
		return reverse(s.substring(1))+s.charAt(0);
	}

}
