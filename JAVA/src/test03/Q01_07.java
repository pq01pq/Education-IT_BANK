package test03;

public class Q01_07 {

	public static void main(String[] args) {
		//1.
		int x = 7;
		int y = x--;
		System.out.println("x = " + x + ", y = " + y); // x = 6, y = 7
		//2.
		int x2 = 7;
		int y2 = ++x2;
		System.out.println("x = " + x2 + ", y = " + y2); // x = 8, y = 8
		//3.
		short s1 = 10;
		short s2 = s1++;
		System.out.println("s1 = " + s1 + ", s2 = " + s2); // s1 = 10, s2 = 10
		//4.
		char ch1 = 'z';
		char ch2 = 'A';
		byte b = 10;
		System.out.println("result = " + (ch1 + ch2 + b));
		//5.
		int x3 = 87;
		int y3 = 73;
		System.out.println("x & y = " + (x3 & y3)); // 65
		//6.
		int x4 = 87;
		int y4 = 73;
		System.out.println("x | y = " + (x4 | y4)); // 95
		//7.
		int x5 = 87;
		int y5 = 73;
		System.out.println("x ^ y = " + (x5 ^ y5));
	}

}
