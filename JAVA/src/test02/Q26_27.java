package test02;

public class Q26_27 {

	public static void main(String[] args) {
		//26. 문자열 35를 숫자로 바꾸려고 한다. 어떻게 해야 하는가 ___ 부분을 채우세요.
		String str = "35";
		//System.out.println((int)'0');
		//int value = (str.charAt(0)- 48) * 10 + (str.charAt(1) - 48);
		int value = Integer.parseInt(str);
		System.out.println(value);
		//27. 숫자 30을 문자열로 바꾸려고 한다. 어떻게 해야 하는가 ____ 부분을 채우세요.
		int value2 = 30;
		String str2 = Integer.toString(value2);
		System.out.println(str2);
	}

}
