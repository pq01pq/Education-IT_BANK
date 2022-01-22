package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
21. 초를 입력받아서 분으로 계산하는 프로그램을 아래와 같이 작성해 보세요.
예시] 시간(단위:초) = 250
250초는 4분 10초 입니다.
*/
public class Q21 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시간(단위:초) = ");
		int second = Integer.parseInt(br.readLine());
		int restSecond = second % 60;
		int minute = second / 60;
		
		System.out.printf("%d초는 %d분 %d초 입니다.\n", second, minute, restSecond);
		
		br.close();
	}

}
