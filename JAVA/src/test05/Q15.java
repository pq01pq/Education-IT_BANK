package test05;

import java.util.Arrays;

/**
15. 다음은 버블정렬을 수행하는 알고리즘입니다.
(그림)
위의 버블정렬 알고리즘을 참고하여 아래와 같이 진행되는 프로그램을 작성 하세요
숫자 개수 = 5
숫자 1 = 7
숫자 2 = 5
숫자 3 = 8
숫자 4 = 4
숫자 5 = 2
결과출력 : 2 4 5 7 8
 */
public class Q15 {

	public static void main(String[] args) {
		int[] array = { 7, 5, 8, 4, 2 };
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
	}

}
