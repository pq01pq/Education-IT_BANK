package test04;

import java.io.IOException;

/**
9. 아래와 같이 동작되는 단 자리 계산기 프로그램을 작성해 보세요.
단, 사칙연산만 수행하며 입력은 반드시 0~9사이의 숫자만 넣는다.
(System.in.read()를 이용할 것)
숫자 1 = 5
연산자 = +
숫자 2 = 7
연산결과 : 12
 */

public class Q09 {
	
	public static void main(String[] args) throws IOException {
		System.out.print("숫자 1: ");
		int a = System.in.read() - '0';		System.in.read();System.in.read();
		System.out.print("연산자: ");
		int operator = System.in.read();	System.in.read();System.in.read();
		System.out.print("숫자 2: ");
		int b = System.in.read() - '0';		System.in.read();System.in.read();
		
		int result = 0;
		switch (operator) {
		case '+':
			result = a + b; break;
		case '-':
			result = a - b; break;
		case '*':
			result = a * b; break;
		case '/':
			try {
				result = a / b; break;
			}
			catch (ArithmeticException e) {
				System.out.println("Divided by zero");
				return;
			}
		default :
			System.out.println("연산자 아님"); return;
		}
		
		System.out.println("연산 결과: " + result);
	}

}
