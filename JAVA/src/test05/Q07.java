package test05;
/**
7. 3과목의 점수를 입력받아서 합격이지 불합격인지 출력하는 프로그램을 작성하세요.
단, 3개의 과목이 전부 40이상이어야 하고 평균이 60이어야 "합격"을 출력하고
평균이 60이 넘지만 1개의 과목이라도 40 미만이면 "과락으로 불합격"을 출력하며
평균이 60미만이면 "불합격"을 출력한다.
실행예시 1 :
실행방법 : java ExamEx06 75 80 100
결과 = 합격
실행예시 2 :
실행방법 : java ExamEx06 95 80 38
결과 = 과락으로 불합격
실행예시 3 :
실행방법 : java ExamEx06 32 40 22
결과 = 불합격
 */
public class Q07 {

	public static void main(String[] args) {
		int[] scores = new int[3];
		int total = 0;
		double average = 0.0;
		for(int i = 0; i < args.length; i++) {
			scores[i] = Integer.parseInt(args[i]);
			total += scores[i];
		}
		
		if ((average = (double) total / args.length) < 60.0) {
			System.out.println("결과 : 불합격");
		}
		else {
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] < 40) {
					System.out.println("결과 : 과락으로 불합격");
					return;
				}
			}
			System.out.println("결과 : 합격");
		}
	}

}
