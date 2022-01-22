package test04;

import java.io.IOException;

/**
10. 단을 입력받아서 구구단을 출력하는 프로그램을 작성하세요.
(System.in.read() 사용할 것)
단을 입력하시오 : 2
2 X 1 = 2
2 X 2 = 4
2 X 3 = 6
2 X 4 = 8
2 X 5 = 10
2 X 6 = 12
2 X 7 = 14
2 X 8 = 16
2 X 9 = 18
 */
public class Q10 {

	public static void main(String[] args) throws IOException {
		System.out.print("단 입력: ");
		int base = System.in.read() - '0';	System.in.read();System.in.read();
		for(int i = 1; i < 10; i++) {
			System.out.printf("%d x %d = %d\n", base, i , base * i);
		}
	}

}
