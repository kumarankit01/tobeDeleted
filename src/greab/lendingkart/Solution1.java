package greab.lendingkart;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMin("101"));
		System.out.println(canMakePalindrom("aba"));
	}
	private static boolean canMakePalindrom(String s) {
	    Map<Character, Integer> charCount = new HashMap<>();

	    // Count the occurrences of each character
	    for (char c : s.toCharArray()) {
	        Integer count = charCount.get(c);
	        if (count == null) {
	            count = Integer.valueOf(1);
	        } else {
	            count = count + 1;
	        }
	        charCount.put(c, count);
	    }

	    boolean hasOdd = false;
	    for (int count : charCount.values()) {
	        if (count % 2 == 1) {
	            if (hasOdd) {
	                return false;
	            } else {
	                hasOdd = true;
	            }
	        }
	     }
	     return true;
	}
	static int getMin(String s) {
		int count = 1;
		long totalSum = 0;
		int pow = 0;
		boolean minFound = false;
		char [] bits = s.toCharArray();
		for (int i = bits.length-1; i >=0; i--,pow++) {
			totalSum = (int) (totalSum + (Math.pow(2, pow)*Character.getNumericValue(bits[i])));
			if(totalSum !=0 && totalSum % 5 == 0 && !minFound){
				count = pow+1;
				minFound = true;
			}
		}
		int n = (int) (Math.log(totalSum)/Math.log(5));
		if(Math.pow(5, n) == totalSum){
			return 1;
		}
		while(totalSum != 1){
			if(totalSum % 5 != 0){
				break;
			}
			totalSum = totalSum/5;
			if(totalSum == 1){
				return 1;
			}
		}
		if(minFound){
			return count;
		}else{
			return -1;
		}

	}

}
class Food {
	String food;
	public void serveFood(){
		System.out.println("I'm serving "+food);
	}
}
class FastFood extends Food{
	public FastFood(String s) {
		this.food = s;
	}	
}
class Fruit extends Food{
	public Fruit(String s) {
		this.food = s;
	}
}
class FoodFactory extends Food {
	public Food getFood(String s){
		if(s.equals("FastFood")){
			return new FastFood("FastFood");
		}else if(s.equals("Fruit")){
			return new Fruit("Fruit");
		}
		return null;
	}
}
