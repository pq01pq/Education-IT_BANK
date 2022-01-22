package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
18. 국어점수 영어점수 수학점수를 입력받아 총첨과 평균을 출력해주는 프로그램을 작성하세
요.
예시] 이름 = 홍길동
국어점수 = 99
영어점수 = 88
수학점수 = 79
홍길동님의 총점은 266점이고 평균은 88.67점입니다.
*/
public class Q18 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름: ");
		String name = br.readLine();
		System.out.print("국어점수: ");
		int koreanScore = Integer.parseInt(br.readLine());
		System.out.print("영어점수: ");
		int englishScore = Integer.parseInt(br.readLine());
		System.out.print("수학점수: ");
		int mathScore = Integer.parseInt(br.readLine());
		
		int total = koreanScore + englishScore + mathScore;
		double average = (double) total / 3;
		
		System.out.printf("%s님의 총점은 %d점이고 평균은 %.2f점입니다.\n",
				name, total, average);
		
		br.close();
		
	}

}
