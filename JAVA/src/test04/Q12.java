package test04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
12. 1 ~ 100사이의 난수 2개 발생하여 출력(a, b)합니다 답(dap)을 입력받아 맞는지 틀리는지
출력하는 프로그램을 작성하세요. 한 문제당 10점(score)처리하여 10문제를 풉니다.
아래의 예시처럼 동작하도록 작성합니다.
[1] 23 + 56 = 70
틀렸습니다. 정답은 79 입니다.
[2] 13 + 45 = 58
정답입니다.
// 같은 방식으로 계속해서 10회까지 진행합니다.
[10] 10 + 25 = 35
정답입니다.
당신의 점수는 XX점입니다.
계속하시겠습니까? (y/n) : n //만약 여기서 y를 입력하면 다시 10회 반복한다.
프로그램을 종료합니다.
 */
public class Q12 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		int num1 = 0, num2 = 0;
		int answer = 0;
		
		outer: while (true) {
			int score = 0;
			for(int i = 0; i < 10; i++) {
				num1 = ((rand.nextInt() >>> 1) % 100) + 1 ;
				num2 = ((rand.nextInt() >>> 1) % 100) + 1 ;
				System.out.printf("[%d] %d + %d = ", i + 1, num1, num2);
				answer = Integer.parseInt(br.readLine());
				if (answer == num1 + num2) {
					System.out.println("정답입니다.");
					score++;
				}
				else {
					System.out.println("오답입니다. 정답은 " + (num1 + num2) + "입니다.");
				}
			}
			
			System.out.println("당신의 점수는 " + score + "점입니다.");
			System.out.print("계속하시겠습니까?(y/n): ");
			
			String keep;
			while (true) {
				keep = br.readLine();
				if (keep.equals("y")) {
					continue outer;
				} else if (keep.equals("n")) {
					System.out.println("프로그램을 종료합니다.");
					break outer;
				}
				else {
					System.out.print("잘못 입력하셨습니다. 다시 입력하세요: ");
				}
			}
		}
		
		br.close();
	}

}
