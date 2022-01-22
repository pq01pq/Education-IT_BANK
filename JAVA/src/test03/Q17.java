package test03;

import java.io.IOException;
/**
17. 단 자리 숫자 2개를 입력받아서 합 차 곱 나누기 나눗셈의 나머지를 구하는 프로그램을
작성하세요. (System.in.read()를 이용할 것)
예시] 숫자1 = 9
숫자2 = 2
두 숫자의 합은 11 이고 차는 7 이며
곱은 18 나눈 값은 4 이고 나눗셈의 나머지는 1입니다.
*/
public class Q17 {

	public static void main(String[] args) throws IOException {

		System.out.print("숫자1: ");
		int a = System.in.read() - '0';
		System.in.read();System.in.read();
		//System.out.println(a);
		
		System.out.print("숫자2: ");
		int b = System.in.read() - '0';
		System.in.read();System.in.read();
		//System.out.println(b);
		
		System.out.printf("두 숫자의 합은 %d 이고 차는 %d 이며\n"
				+ "곱은 %d 나눈 값은 %d 이고 나눗셈의 나머지는 %d입니다.\n",
				a + b, a - b, a * b, a / b, a % b);
	}

}
