package greab.lendingkart;
public class IR{
	static int test;
	{
		System.out.println(test);
	}
	public static void main(String[] args) {
		IR ir = new IR();
		System.out.println(x);
	}
	public static int x = 10;
	static{
		System.out.println(test);
		test = 500;
	}
	static void print(){
		test = test - 100;
		System.out.println(test);
	}
}
