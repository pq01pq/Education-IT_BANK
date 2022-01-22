package test05;

import java.io.IOException;

/**
17. 아래의 코드는 마방진의 일부입니다.
프로그램이 정상적으로 수행될 수 있도록 코드를 추가해 주세요.
 */
public class Q17 {

	public static void main(String[] args) throws IOException {
		System.out.print("숫자(홀수만) : ");
		int num = System.in.read() - 48;	System.in.read();System.in.read();
		int[][] mabang = new int[num][num];// 배열생성
		int row = 0;
		int col = num / 2;
		for (int su = 1; su <= num * num; su++) {
			mabang[row][col] = su;
			//여기에 코드를 추가합니다.
			if (mabang[(row - 1 + num) % num][(col - 1 + num) % num] == 0) {
				row = (row - 1 + num) % num;
				col = (col - 1 + num) % num;
			}
			else {
				row++;
			}
		}
		
		//결과출력
		System.out.println();
		for (int i = 0; i < mabang.length; i++) {
			for (int j = 0; j < mabang[i].length; j++) {
				System.out.print(mabang[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
