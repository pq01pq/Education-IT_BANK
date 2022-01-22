package test05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 18. 아래의 프로그램은 로또 추천 프로그램의 일부입니다. 여러 게임을 할 경우에도 서로 다른 게임이 완전히 일치하지 않는다는 것을 보증할
 * 수 있도록 코드를 추가해서 프로그램을 완성해 주세요.
 */

public class Q18 {

	static final boolean DEBUG = true;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lotto[][]; // 로또 저장할 배열공간 선언
		System.out.print("\t몇 게임을 하실꺼에요 ? ");
		int number = Integer.parseInt(br.readLine());
		lotto = new int[number][6]; // 2차원 배열 초기화
		for (int i = 0; i < number; i++) {// 내가 선택 게임수 만큼
			for (int j = 0; j < lotto[i].length; j++) {
				lotto[i][j] = (int) (Math.random() * 45) + 1;
				compareNumber: for (int k = 0; k < j; k++) {
					// 같은 게임 내 같은 수 있을 경우 다시 난수 생성
					if (lotto[i][j] == lotto[i][k]) {
						j--;
						break compareNumber;
					}
				}
			}
			// 여기에 알맞은 코드를 추가해 주세요.
			for (int p = 0; p < lotto[i].length - 1; p++) {
				for (int q = p + 1; q < lotto[i].length; q++) {
					if (lotto[i][p] > lotto[i][q]) {
						int temp = lotto[i][p];
						lotto[i][p] = lotto[i][q];
						lotto[i][q] = temp;
					}
				}
			}
			// 현재 생성된 게임 : lotto[i]
			compareGame: for (int p = 0; p < i; p++) {
				int countSame = 0;
				for (int q = 0; q < lotto[i].length; q++) {
					for (int r = 0; r < lotto[i].length; r++) {
						if (lotto[p][q] == lotto[i][r]) {
							countSame++;
						}
					}
				}
				if (DEBUG) {
					System.out.printf("[%d & %d] 같은수 갯수 : %d\n", i + 1, p + 1, countSame);
				}
				// 게임이 아예 같을경우 다시 게임 생성
				if (countSame == lotto[i].length) {
					i--;
					break compareGame;
				}
			}

		}

		// 결과출력
		for (int i = 0; i < number; i++) {
			System.out.print("\t" + (i + 1) + "번째 추천번호 : ");
			for (int j = 0; j < lotto[i].length; j++) {
				if (lotto[i][j] >= 10)
					System.out.print(" " + lotto[i][j]);
				else
					System.out.print(" " + lotto[i][j]);
			}
			System.out.println();
		}
	}
}
