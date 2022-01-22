package test04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
13. 1 ~ 200사이의 난수를 발생하여 데이터를 입력받아서 발생한 숫자를 맞추는 프로그램을
아래와 같이 작성해 보세요. 단 10회의 기회를 제공하고 10회안에 맞추지 못할 경우
틀린 것으로 간주하여 게임을 종료하고 계속 진행할 것인지를 묻도록 한다.
** 1 ~ 200 사이의 난수를 발생하였습니다. **
** 맞추어 보세요. ** (예를 들어 발생한 숫자가 80이라고 가정하면)
데이터 입력 : 50
컴퓨터 발생한 숫자가 더 큽니다.
데이터 입력 : 100
컴퓨터 발생한 숫자가 더 작습니다.
// 이렇게 10회의 기회를 제공한다.
데이터 입력 : 80
정답입니다. XX번만 에 맞추셨습니다.
// 만약 10회 안에 못 맞출 경우 실패하였다는 메시지를 출력하고
// 아래처럼 계속 진행할 것인지 여부를 물어본다.
계속하시겠습니까? (y/n) : n
//만약 여기서 y를 입력하면 다시 게임을 진행한다.
프로그램을 종료합니다.
 */
public class Q13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		int randomNumber = 0;
		int number = 0;
		
		System.out.println("난수 맞추기 (1~200)");
		
		outer: while (true) {
			randomNumber = ((rand.nextInt() >>> 1) % 200) + 1;
			
			boolean found = false;
			for (int i = 0; !found && i < 10; i++) {
				System.out.print("데이터 입력: ");
				number = Integer.parseInt(br.readLine());
				if (number < randomNumber) {
					System.out.println("컴퓨터가 발생한 숫자가 더 큽니다.");
				} else if (number > randomNumber) {
					System.out.println("컴퓨터가 발생한 숫자가 더 작습니다.");
				} else {
					System.out.println("정답입니다. " + (i + 1) + "번만에 맞추셨습니다.");
					found = true;
				}
			}
			if (!found) {
				System.out.println("난수 맞추기에 실패하셨습니다.");
			}
			
			System.out.print("계속하시겠습니까?(y/n): ");
			String keep;
			while (true) {
				keep = br.readLine();
				if (keep.equals("y")) {
					continue outer;
				} else if (keep.equals("n")) {
					System.out.println("프로그램을 종료합니다.");
					break outer;
				} else {
					System.out.print("잘못 입력하셨습니다. 다시 입력하세요: ");
				}
			}
		}
		
		br.close();
	}

}
