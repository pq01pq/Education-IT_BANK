package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11 {

	public static void main(String[] args) throws IOException {
		int num1 = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자입력 = ");
		String num2 = br.readLine(); // 여기서 3을 입력한다.
		System.out.println("계산결과 = " + (num1 + num2));
	}

}
