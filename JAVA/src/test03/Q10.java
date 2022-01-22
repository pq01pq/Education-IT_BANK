package test03;

import java.util.Random;

public class Q10 {

	public static void main(String[] args) {
		Random rand = new Random();
		int number = rand.nextInt();
		//number 변수에는 int(-2147483648~2147483647) 범위의 랜덤 값이 하나 들어간다.
		int num = 6;
		System.out.println( (number>>>1) % num + 1); // 1~6까지 자연수가 랜덤하게 나옴
		// >>> 연산자는 오른쪽으로 쉬프트하고 앞의 비트를 0으로 채워넣음
		// 양의 정수로 바꿔주는 테크닉
	}

}
