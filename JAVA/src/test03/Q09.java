package test03;

import java.io.IOException;

public class Q09 {
	
	public static void main(String[] args) throws IOException {
		System.out.print("입력1 = ");
		int num1 = System.in.read() - '0';// 이곳에서 3을 입력
		System.in.read();System.in.read();
		System.out.print("입력2 = ");
		int num2 = System.in.read() - 48;// 이곳에서 5를 입력
		System.in.read();System.in.read();
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
	}

}
