package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
22. 금액을 입력받아서 화폐의 개수를 구하는 아래와 같이 프로그램을 작성하세요.
단 금액은 10원 이상 10만원 미만의 금액만 입력한다.
예시] 금액 = 57620
만원 = 5장
천원 = 7장
백원 = 6개
십원 = 2개
 */
public class Q22 {

	public static void main(String[] args) throws IOException {
		/*

		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("금액 : ");
		int amountOfMoney = Integer.parseInt(br.readLine());
		int divisor = 1;
		while(amountOfMoney % divisor < amountOfMoney && divisor < 100000) {
			divisor *= 10;
		}
		divisor /= 10;
		
		int countBills = 0;
		int restMoney = amountOfMoney;
		while(divisor > 1) {
			countBills = restMoney / divisor;
			switch (divisor) {
			case 10000 :
				System.out.println("만원 : " + countBills + "장"); break;
			case 1000  :
				System.out.println("천원 : " + countBills + "장"); break;
			case 100   :
				System.out.println("백원 : " + countBills + "개"); break;
			case 10    :
				System.out.println("십원 : " + countBills + "개"); break;
			default :
				 break;
			}
			restMoney -= countBills * divisor;
			divisor /= 10;
		}
		
		br.close();
	}

}
