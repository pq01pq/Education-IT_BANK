package test05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
12. 아래와 같이 실행되는 야구게임을 만들어 봅시다.
단, 숫자는 무조건 3자리이며, 컴퓨터가 랜덤하게 만들어 냅니다.
(예를 들어 컴퓨터가 863이란 숫자를 만들어 낸 경우를 가정하겠습니다.)
게임을 실행 하시겠습니까? (y/n) : y
숫자를 생성했습니다.
당신이 생각하는 숫자 = 357
1 구 : 1볼
당신이 생각하는 숫자 = 835
2 구 : 1스트라이크 1볼
// 이런 식으로 계속해서 10구까지 진행합니다.
// 만약 10구 이내에 맞추지 못한다면 실패했다는 메시지를 출력하고 종료합니다.
당신이 생각하는 숫자 = 863
정답입니다.^^
 */
public class Q12 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		System.out.print("게임을 실행 하시겠습니까? (y/n) : ");
		while (true) {
			String keep = br.readLine();
			if (keep.equals("y")) {
				break;
			} else if (keep.equals("n")) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.print("잘못 입력하셨습니다. 다시 입력하세요: ");
			}
		}
		
		int randomNumber = ((rand.nextInt() >>> 1) % 899) + 1;
		System.out.println("숫자를 생성했습니다.");
		
		String randomNumberString = Integer.toString(randomNumber);
		String inputNumberString;
		int countStrike = 0, countBall = 0;
		boolean[] found = new boolean[3];
		for(int i = 0; i < 10; i++) {

			System.out.print("당신이 생각하는 숫자: ");
			inputNumberString = br.readLine();
			
			for(int j = 0; j < randomNumberString.length(); j++) {
				if(randomNumberString.charAt(j) == inputNumberString.charAt(j)) {
					found[j] = true;
					System.out.println("맞춘 자릿수: " + j + "번째 자리");
				}
				else {
					found[j] = false;
				}
			}
			
			boolean ballStrike = false;
			for(int j = 0; j < randomNumberString.length(); j++) {
				ballStrike |= found[j];
			}
			
			if(ballStrike) {
				countStrike++;
			}
			else {
				countBall++;
			}
			
			if(countStrike == 0) {
				System.out.println((i + 1) + "구 : " + countBall + "볼");
			}
			else if(countBall == 0) {
				System.out.println((i + 1) + "구 : " + countStrike + "스트라이크");
			}
			else {
				System.out.println((i + 1) + "구 : " + countStrike + "스트라이크 " + countBall + "볼");
			}
		}
		
//		int[] numbers = new int[3];
//		int restNumber = randomNumber;
//		int divisor = 10;
//		for(int i = numbers.length - 1; i >= 0 && restNumber > 0; i--) {
//			numbers[i] = restNumber % divisor;
//			restNumber /= divisor;
//		}
//		int inputNumber = 0;
//		int[] myNumber = new int[3];
//		for (int i = 0; i < 10; i++) {
//			System.out.print("당신이 생각하는 숫자: ");
//			inputNumber = Integer.parseInt(br.readLine());
//		}
		
		br.close();
	}

}
