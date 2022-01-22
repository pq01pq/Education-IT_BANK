package test05;

import java.util.Arrays;

/**
16. 다음은 선택정렬 알고리즘입니다.
(그림)
위의 선택정렬 알고리즘을 참고하여 아래와 같이 진행되는 프로그램을 작성 하세요
숫자 개수 = 5
숫자 1 = 7
숫자 2 = 5
숫자 3 = 8
숫자 4 = 4
숫자 5 = 2
결과출력 : 2 4 5 7 8
 */
public class Q16 {

	public static void main(String[] args) {
		int[] array = { 7, 5, 8, 4, 2 };
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
	}

}
