package test05;

/**
8. 시작 값과 끝 값을 입력하여 시작부터 끝 값까지 출력하고 합을 구하는 프로그램을 작성하세요
실행예시 1 :
실행방법 : java ExamEx08 2 20
2 3 4 5 6 7 8 ... 18 19 20
합 = 209
실행예시 2 :
실행방법 : java ExamEx08 20 2
2 3 4 5 6 7 8 ... 18 19 20
합 = 209
 */
class Serial {
	int startNumber;
	int finishNumber;
	
	Serial(int startNumber, int finishNumber){
		this.startNumber = startNumber;
		this.finishNumber = finishNumber;
	}
}

public class Q08 {
	
	static void swap(Serial serial, int a, int b) {
		serial.startNumber = b;
		serial.finishNumber = a;
	}
	
	public static void main(String[] args) {
		Serial serial = new Serial(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		
		if(serial.startNumber > serial.finishNumber) {
			swap(serial, serial.startNumber, serial.finishNumber);
		}
		
		int sum = 0;
		for (int i = serial.startNumber; i <= serial.finishNumber; i++) {
			System.out.print(i + " ");
			if (i % 10 == 0) {
				System.out.println();
			}
			sum += i;
		}
		System.out.println();
		System.out.println("합 : " + sum);
	}

}
