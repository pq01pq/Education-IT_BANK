package test04;
/**
아래의 실행결과를 예측해 보세요.
 */
public class Q01_08 {

	public static void main(String[] args) {
		
		// 1.
		int i = 1;
		int j = i++;
		if ((i > ++j) & (i++ == j)) {
			i += j;
		}
		System.out.println("i=" + i + ", j=" + j); // i = 3, j = 2

		// 2.
		int i2 = 1;
		int j2 = i2++;
		if ((i2 > ++j2) && (i2++ == j2)) {
			i2 += j2;
		}
		System.out.println("i=" + i2 + ", j=" + j2); // i = 2, j = 2

		// 3.
		int i3 = 1;
		int j3 = i3++;
		if ((i3 > j3++) | (i3++ == j3)) {
			i3 += j3;
		}
		System.out.println("i=" + i3 + ", j=" + j3); // i = 5, j = 2

		// 4.
		int i4 = 1;
		int j4 = i4++;
		if ((i4 > j4++) || (i4++ == j4)) {
			i4 += j4;
		}
		System.out.println("i=" + i4 + ", j=" + j4); // i = 4, j = 2

		// 5.
		int i5 = 0, j5 = 5;
		tp: for (;; i5++) {
			for (;; --j5) {
				if (i5 > j5)
					break tp;
			}
		}
		System.out.println("i = " + i5 + ", j = " + j5); // i = 0, j = -1

		// 6.
		int i6 = 0;
		int j6 = 5;
		tp: for (;;) {
			i6++;
			for (;;) {
				if (i6 > --j6)
					break tp;
			}
		}
		System.out.println("i :" + i6 + ", j :" + j6); // i = 1, j = 0

		// 7.
		int i7 = 1;
		int j7 = 0;
		switch (i7) {
		case 2:
			j7 += 6;
		case 4:
			j7 += 1;
		default:
			j7 += 2;
		case 0:
			j7 += 4;
		}
		System.out.println("i :" + i7 + ", j :" + j7); // i = 1, j = 6
		// break 없으면 아래로 전부 실행

		// 8.
		int i8 = 1;
		int j8 = 10;
		do {
			if (i8 > j8)
				break;
			j8--;
		} while (++i8 < 5);
		System.out.println("i = " + i8 + ", j = " + j8 + ", i & j = " + String.valueOf(i8 & j8));
		// i = 5, j = 6, i & j = 4
	}

}
