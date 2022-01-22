package test05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
14. 주민번호를 입력받아서 개인정보를 출력해 주는 프로그램을 아래와 같이 작성하세요.
이 름 : 홍길동
주민번호 : 1234567890123
올바른 주민번호일 경우 출력
홍길동님의 개인정보 분석결과
생년월일 : 1912년 34월 56일생
나 이 : 106세
성 별 : 남성
출생지역 : 경남출생
잘못된 주민번호일 경우 출력
잘못된 주민번호입니다.
 */
/*
참고사항 :
정보입력 방법
이 름 : 박성현 ( br.readLine(); )
주민번호 : 123456 1234567
int[] jumin = new jumin[13];
System.in.read(); //이용해서 입력
for(int i=0; i<jumin.length; i++)
주민번호확인 방법
1 2 3 4 5 6 - 1 2 3 4 5 6 7
* 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 2.0 3.0 4.0 5.0
-----------------------------------------------------------------------------
X + X + X + X + X + X + X + X + X + X + X + X = Hap
Temp = 11.0f * (int)(Hap/11.0f) + 11.0f - Hap
Total = Temp - 10.0f * (int)(Temp/10.0f)
올바른 주민번호 : Total == 7번자리...(jumin[jumin.length-1])
만약 다르다면 잘못된 주민번호...

정보분석 방법
1. 출생년도 확인 방법
주민번호 뒷부분의 첫 번째 자리가 아래와 같다면
9 0 : 1800년도
1 2 : 1900년도
3 4 : 2000년도
5 6 : 외국인(1,2 포함)
2. 출생지역 확인 방법
주민번호 뒷부분의 두 번째 자리는 시도를 의미한다.
0 서울 1 경기 2 강원
3 충북 4 충남 5 전북
6 전남 7 경북 8 경남
9 제주
 */
public class Q14 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 : ");
		String name = br.readLine();
		int[] idArray = new int[13];
		
		while (true) {
			System.out.print("주민번호 : ");
			for (int i = 0; i < idArray.length; i++) {
				idArray[i] = System.in.read() - '0';
			}
			System.in.read();System.in.read();
			
//			int sum = 0;
//			for (int i = 0; i < idArray.length - 1; i++) {
//				sum += idArray[i];
//			}
//			
//			double temp = 11.0f * (int) (sum / 11.0f) + 11.0f - sum;
//			double total = temp - 10.0f * (int) (temp / 10.0f);
//			if ((int)total != idArray[idArray.length - 1]) {
//				System.out.println("잘못된 주민번호입니다.");
//				return;
//			}
//			
//			String idString = br.readLine();
//			for (int i = 0; i < idArray.length; i++) {
//				if (idString.charAt(i) < '0' || idString.charAt(i) > '9') {
//					System.out.println("주민번호를 잘못 입력하셨습니다. 다시 입력하세요.");
//					continue outer;
//				}
//				idArray[i] = idString.charAt(i) - '0';
//			}
			break;
		}
		
		System.out.println(name + "님의 개인정보 분석 결과");
		int decade = 0;
		String gender = null;
		switch(idArray[6]) {
		case 9:
			gender = "남성";
			decade = 1800; break;
		case 0:
			gender = "여성";
			decade = 1800; break;
		case 1:
			gender = "남성";
			decade = 1900; break;
		case 2:
			gender = "여성";
			decade = 1900; break;
		case 3:
			gender = "남성";
			decade = 2000; break;
		case 4:
			gender = "여성";
			decade = 2000; break;
		// 외국인
		case 5:
			gender = "남성";
			break;
		case 6:
			gender = "여성";
			break;
		default :
			break;
		}
		
		String location = null;
		switch(idArray[7]) {
		case 0:
			location = "서울"; break;
		case 1:
			location = "경기"; break;
		case 2:
			location = "강원"; break;
		case 3:
			location = "충북"; break;
		case 4:
			location = "충남"; break;
		case 5:
			location = "전북"; break;
		case 6:
			location = "전남"; break;
		case 7:
			location = "경북"; break;
		case 8:
			location = "경남"; break;
		case 9:
			location = "제주"; break;
		default :
			break;
		}
		
		int year = decade + (idArray[0] * 10) + idArray[1];
//		int age = Calendar.YEAR - year + 1;
		int age = 2020  - year + 1;
		System.out.println("생년월일 : " + year + "년 " +
		idArray[2] + idArray[3] + "월 " + idArray[4] + idArray[5] + "일생");
		System.out.println("나    이 : " + age + "세");
		System.out.println("성    별 : " + gender);
		System.out.println("출생지역 : " + location);
		
		br.close();

	}

}
