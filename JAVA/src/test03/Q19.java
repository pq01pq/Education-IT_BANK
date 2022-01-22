package test03;

import java.io.IOException;
/**
19. 영어 알파벳을 입력받아서 대문자 이면 소문자로 소문자이면 대문자로 바꾸어주는 프로그
램을 작성하세요. (System.in.read()와 if~else 문을 이용할 것)
예시] 알파벳입력 = A
변경된 알파벳은 a입니다.
또는 알파벳입력 = a
변경된 알파벳은 A입니다.
*/
public class Q19 {
	
	public static void main(String[] args) throws IOException {

		System.out.print("알파벳 입력: ");
		int c = System.in.read();	System.in.read();System.in.read();
		
		if (c >= 'a' && c <= 'z') {
			c += 'A' - 'a';
		}
		else if (c >= 'A' && c <= 'Z') {
			c -= 'A' - 'a'; 
		}
		else {
			System.out.println("알파벳 아님");
			return;
		}
		
		System.out.println("변경된 알파벳은 " + (char) c + "입니다.");
		
		return;
	}

}
