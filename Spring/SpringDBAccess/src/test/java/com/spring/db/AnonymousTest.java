package com.spring.db;

public class AnonymousTest {

	public static void main(String[] args) {
		Car sonata = new Sonata();
		sonata.run();
		
		// 변수가 있는 익명클래스 생성
		Car tesla = new Car() {
			@Override
			public void run() {
				System.out.println("테슬라는 소리없이 달린다.");
			}
		};
		tesla.run();
		
		// 변수가 없는 익명클래스 생성
		// 재사용 불가
		new Car() {
			@Override
			public void run() {
				System.out.println("포르쉐는 팍팍 달린다.");	
			}
		}.run();
		
		// lambda식 적용 : 인터페이스 안에 추상메서드가 단 하나일 경우에만 가능
		Car morning = () -> {
			System.out.println("모닝이 뽈뽈뽈 달린다.");
		};
		
		morning.run();
		
		System.out.println("-----------------------------------");
		
		// 계산기 인터페이스와 람다식
		Calculator sharp = new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("샤프 계산기의 덧셈");
				return n1 + n2;
			}
		};
		System.out.println(sharp.add(10, 15));
		
		Calculator casio = (x, y) -> {
			System.out.println("카시오 계산기의 덧셈");
			return x + y;
		};
		System.out.println(casio.add(100, 200));
		
		Calculator xiaomi = (x, y) -> x + y;
		System.out.println("샤오미의 계산결과 : " + xiaomi.add(30, 50));
	}

}
