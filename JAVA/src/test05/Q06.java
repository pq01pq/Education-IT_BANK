package test05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
6. 이름(name), 국어(kor), 영어(eng), 수학(mat) 점수를 입력받아서 총점(tot), 평균(avg)을 구하는
프로그램을 작성하세요.
이때 평균은 소수점 3째 자리에서 반올림해서 소수저점 2째 자리까지 출력한다.
실행방법 : java ExamEx05 홍길동 100 100 96
*** 홍길동 성적표 ***
국어 영어 수학 총점 평균
100 100 96 296 98.67
 */
public class Q06 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = args[0];
		int koreanScore = Integer.parseInt(args[1]);
		int englishScore = Integer.parseInt(args[2]);
		int mathScore = Integer.parseInt(args[3]);
		int total = koreanScore + englishScore + mathScore;
		double average = (double) total / (args.length - 1);
		
		System.out.println("*** " + name + " 성적표 ***");
		System.out.println("국어	영어	수학	총점	평균");
		System.out.printf("%d	%d	%d	%d	%.2f",
				koreanScore, englishScore, mathScore, total, average);
		
		br.close();
	}

}
