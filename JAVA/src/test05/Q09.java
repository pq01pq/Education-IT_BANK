package test05;
/**
9. 정수를 입력받아서 1 ~ 정수까지 약수를 구하는 프로그램을 작성하세요.
약수는 나누어서 떨어지는 수를 말합니다. (예 9의 약수는 1, 3, 9)
실행방법 : java ExamEx09 52
결과출력 : 1 2 4 13 26 52
 */
public class Q09 {

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		
		for(int i = 1; i <= x; i++) {
			if(x % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

}
