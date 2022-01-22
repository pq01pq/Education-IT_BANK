package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
20. 밑변과 높이를 입력받아서 삼각형의 넓이를 구하는 프로그램을 작성하세요.
삼각형의 넓이를 구하는 공식은 [넓이 = 밑변 * 높이 / 2] 이다.
예시] 밑변 = 5
높이 = 7
삼각형 넓이 = 17.5
*/
public class Q20 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("밑변: ");
		double base = (double) Double.parseDouble(br.readLine());
		System.out.print("높이: ");
		double height = (double) Double.parseDouble(br.readLine());
		
		double area = base * height / 2.0;
		
		System.out.printf("삼각형 넓이 = %.2f\n", area);
		
		br.close();
	}

}
