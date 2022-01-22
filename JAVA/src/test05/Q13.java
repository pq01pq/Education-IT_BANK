package test05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
13. 아래와 같이 동작하는 가위바위보 게임을 만드세요.
money = 1000; // 게임이 시작되면 무조건 1000원의 잔액을 드립니다.
1. 가위
2. 바위
3. 보
0. 프로그램 종료
메뉴선택 : 1
배팅금액 : 200
결과를 보려면 Enter를 치세요^^ Enter
computer : 보자기, you : 주먹
You win !!! 잔액 : 1200원
// 여기서 다시 처음 메뉴로 이동합니다.
// 기타 세부적인 규칙은 자유롭게 적용하도록 합니다.
// 예를 들어 돈이 0원이하이면 종료한다. 등
 */
public class Q13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = 1000; // 게임이 시작되면 무조건 1000원의 잔액을 드립니다.
		System.out.println("1. 가위");
		System.out.println("2. 바위");
		System.out.println("3. 보");
		System.out.println("0. 프로그램 종료");
		
		while (true) {
			if (money <= 0) {
				System.out.println("재산을 전부 탕진했습니다.");
				break;
			}
			
			System.out.println();
			System.out.print("메뉴선택: ");
			int myIndex = Integer.parseInt(br.readLine());
			if (myIndex == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			else if (myIndex >= 4) {
				System.out.println("잘못된 번호입니다.");
				continue;
			}
			
			System.out.print("배팅금액: ");
			int betting = Integer.parseInt(br.readLine());
			if (betting > money) {
				System.out.println("재산보다 많이 배팅할 수 없습니다.");
				continue;
			}

			int computerIndex = (int) (Math.random() * 3) + 1;
			
			switch (computerIndex) {
			case 1:
				System.out.print("computer : 가위, "); break;
			case 2:
				System.out.print("computer : 바위, "); break;
			case 3:
				System.out.print("computer : 보, "); break;
			default:
				break;
			}
			
			switch (myIndex) {
			case 1:
				System.out.println("you : 가위"); break;
			case 2:
				System.out.println("you : 바위"); break;
			case 3:
				System.out.println("you : 보"); break;
			default:
				break;
			}
			
			if (myIndex - computerIndex == 2 || myIndex - computerIndex == -2) {
				computerIndex %= 3;		myIndex %= 3;
			}
			
			if (myIndex - computerIndex > 0) {
				money += betting;
				System.out.println("You win!!! 잔액 : " + money);
			} else if (myIndex - computerIndex < 0) {
				money -= betting;
				System.out.println("You lose... 잔액 : " + money);
			} else {
				System.out.println("비김");
			}

//			if (computerIndex == 1) {
//				System.out.print("computer : 가위, ");
//				if (myIndex == 1) {
//					System.out.println("you : 가위");
//				} else if (myIndex == 2) {
//					System.out.println("you : 바위");
//				} else if (myIndex == 3) {
//					System.out.println("you : 보");
//				}
//			} else if (computerIndex == 2) {
//				System.out.print("computer : 바위, ");
//				if (myIndex == 1) {
//					
//				} else if (myIndex == 2) {
//					
//				} else if (myIndex == 3) {
//					
//				}
//			} else if (computerIndex == 3) {
//				System.out.print("computer : 보, ");
//				if (myIndex == 1) {
//					
//				} else if (myIndex == 2) {
//					
//				} else if (myIndex == 3) {
//					
//				}
//			}

		}

		br.close();
	}

}
