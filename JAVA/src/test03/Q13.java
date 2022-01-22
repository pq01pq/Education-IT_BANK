package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자입력 = ");
		int number = Integer.parseInt(br.readLine()); // 여기서 “홍길동”을 입력한다.
		System.out.println("결과 = " + number);
		
		// 예외발생
	}

}
