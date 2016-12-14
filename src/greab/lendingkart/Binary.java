package greab.lendingkart;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getcompliment(50);

	}
	public static int getcompliment(int n){
		String s = Integer.toBinaryString(n);
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0'){
				r += '1';
			}else{
				r+= '0';
			}
		}
		int decimalValue = Integer.parseInt(r, 2);
		return decimalValue;
	}
}
