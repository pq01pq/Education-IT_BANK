package test05;
/**
2. 아래와 같이 배열을 선언하였다. 다음 코드의 결과 값을 예측해 보세요.
int[][] number = { {3,4,5} , {2} , {1,3} };
① number[1].length ② number.length
③ number[2][0] ④ number[1][1]
 */
public class Q02 {

	public static void main(String[] args) {
		int[][] number = {
				{3,4,5},
				{2},
				{1,3}
		};
		System.out.println(number[1].length); // 1
		System.out.println(number.length); // 3
		System.out.println(number[2][0]); // 1
//		System.out.println(number[1][1]); // error
	}

}
