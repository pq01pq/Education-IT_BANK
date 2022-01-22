package test05;
/**
11. 프로그램 시작 시 2개의 매개변수를 받아서 처리하는 프로그램이 있다.
아래와 같이 실행될 수 있도록 작성하세요.
실행예시 1 :
실행방법 : java ExamEx14 3 국어 영어 수학
입력1 = 국어
입력2 = 영어
입력3 = 수학
실행예시2 :
실행방법 : java ExamEx14 2 국어 영어 수학 과학
입력한 숫자와 매개변수의 개수가 올바르지 않습니다.
Usage : java ExamEx count param1 param2 ... paramCOUNT
실행예시 3 :
실행방법 : java ExamEx14 4
매개변수의 개수는 반드시 2개 이상이어야 합니다.
Usage : java ExamEx count param1 param2 ... paramCOUNT
 */
public class Q11 {

	public static void main(String[] args) {
		if(args.length < 3) {
			System.out.println("매개변수의 개수는 반드시 2개 이상이어야 합니다.");
			System.out.println("sage : java ExamEx count param1 param2 ... paramCOUNT");
		}
		else if(Integer.parseInt(args[0]) != args.length - 1) {
			System.out.println("입력한 숫자와 매개변수의 개수가 올바르지 않습니다.");
			System.out.println("sage : java ExamEx count param1 param2 ... paramCOUNT");
		}
		else {
			System.out.println("입력1: " + args[1]);
			System.out.println("입력2: " + args[2]);
			System.out.println("입력3: " + args[3]);
		}
	}

}
