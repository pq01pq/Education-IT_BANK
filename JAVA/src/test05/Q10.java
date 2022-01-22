package test05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
10. 숫자를 입력받아서 2진수로 바꾸어주는 프로그램을 작성해 보세요.
단, 숫자는 0에서 255까지만 입력 합니다.
숫자 = 124
2진수 = 0111 1100
 */
public class Q10 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("숫자: ");
		int x = Integer.parseInt(br.readLine());
		
		int[] reverseBinaryString = new int[8];
		int dividened = x;
		int i = 0;
		while(dividened > 0) {
			reverseBinaryString[i] = dividened % 2;
			dividened /= 2;
			i++;
		}
		
		for(i = reverseBinaryString.length - 1; i >= 0; i--) {
			System.out.print(reverseBinaryString[i]);
			if(i % 4 == 0) {
				System.out.print(" ");
			}
		}

		br.close();
	}

}
