package test02;

public class Q28_33 {

	public static void main(String[] args) {
		//28. 
//		short s;
//		System.out.println("s = " + s);
		//29.
		byte value = 10;
		value++;
		System.out.println("value = " + value); // 11
		//30.
		byte value2 = (byte)10;
		byte x = 5;
		value2 += x;
		System.out.println("value = " + value2); // 15
		//31.
		byte value3 = 10;
		value3 = (byte) (value3 + 2);
		System.out.println("value = " + value3); // 12
		//32.
		char value4 = 'A';
		System.out.println("value = " + value4 + 3);
		//33.
		char ch1 = 'A';
		char ch2 = 'B';
		System.out.println(ch1 + ch2);
	}

}
