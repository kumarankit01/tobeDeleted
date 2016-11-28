import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class LargestNumber {
	private static int[] tempMergArr;
	public static void main(String[] args) {
		ArrayList<Integer> a =new ArrayList<>();
		a.add(0);
		a.add(0);
		//a.add(9);
		//largestNumber(a);
		//tempMergArr = new int[a.size()];
		List<Long> l = new ArrayList<>();
		for (int i : a) {
			l.add((long) i);
		}
		Collections.sort(l, new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				//System.out.println(o1+""+o2);
				Long x = Long.parseLong(o1+""+o2);
				Long y = Long.parseLong(o2+""+o1);
				return y.compareTo(x);
			}

		});
		String s = "";
		//remove leading zero
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Long integer = (Long) iterator.next();
			if(integer>0){
				break;
			}else{
				iterator.remove();
			}
		}
		for (Long integer : l) {
			s +=integer;
		}
		System.out.println(s.length()==0?'0':s);
	}
	
	
	
	public static String largestNumber(final List<Integer> a) {
	
		int[] arr = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			arr[i] = a.get(i);
		}
		mergeSort(0,arr.length);
		return null;
	}
	private static void mergeSort(int start, int end) {
		if(start == end){
			return;
		}
		int mid = (start+end)/2;
		mergeSort(start, mid);
		mergeSort( mid+1, end);
		merge(start,mid,end);
		//System.out.println(start+" "+mid+" "+end);
	}
	private static void merge(int start, int mid, int end) {
		for (int i = start; i < end; i++) {
			//tempMergArr[i] = 
		}
	}
}
