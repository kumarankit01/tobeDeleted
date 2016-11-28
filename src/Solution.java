import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> a) {
	    Collections.sort(a, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				System.out.println(o1+""+o2);
				Integer x = Integer.parseInt(o1+""+o2);
				Integer y = Integer.parseInt(o2+""+o1);
				return y.compareTo(x);
			}

		});
		String s = "";
		for (Integer integer : a) {
			s +=integer;
		}
		System.out.println(s);
		return s;
	}
}
