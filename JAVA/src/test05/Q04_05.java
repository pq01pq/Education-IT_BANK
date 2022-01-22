package test05;
/**
※ 아래 코드의 결과를 예측해 보세요.
 */

public class Q04_05 {

	public static void main(String[] args) {
		
		//4.
		int index = 1;
		int[] foo = new int[3];
		int bar = foo[index];
//		int baz = bar[index]; // error
		System.out.println("bar = " + bar); // bar = 0
		
		//5.
		int index2 = 1;
		boolean[] test = new boolean[3];
		boolean foo2 = test[index2];
		System.out.println("foo = " + foo2); // foo = false
	}

}
