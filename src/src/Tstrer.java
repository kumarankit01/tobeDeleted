package src;
import java.util.ArrayList;

public class Tstrer {

	public static void main(String[] args) {
		//[1, 2, 5, -7, 2, 3]
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(0);
		a.add(-1);
		a.add(2);
		maxset(a);
	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		ArrayList<Integer> al = new ArrayList<>();
		int startpos = 0, lastpos = 0;
		long sum = 0;
		for (int i = 0; i < a.size(); i++) {
			int curPos = 0, endpos = 0;
			long curSum = 0;
			boolean found = false;
			if(a.get(i) >= 0){
				found = true;
				curPos = i;
				curSum = a.get(i);
				i++;
				while(i < a.size() && a.get(i) >= 0){
					curSum+=a.get(i) ;
					i++;
				}
				endpos = i;
			}
			if(found){
				if(curSum > sum){
					sum = curSum;
					startpos = curPos;
					lastpos = endpos;
				}else if(curSum == sum){
					if ((endpos - curPos) > (lastpos - startpos)){
						sum = curSum;
						startpos = curPos;
						lastpos = endpos;
					}
				}
			}

		}
		for (int i = startpos; i < lastpos ; i++) {
			al.add(a.get(i));
			System.out.println(a.get(i));
		}
		return al;


	}

}
