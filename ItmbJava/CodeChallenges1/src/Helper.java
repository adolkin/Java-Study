import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {
//	public static long fibonacci(int n) {
//		List<Long> fibo = Arrays.asList(1L, 2L, 3L);
//		if (n < 2)
//			return n;
//		else
//			for (int i = 1; i <= n; i++) {
//				fibo(i) = fibo(i-1) + fibo(i-2);
//			}
//		return fibo[n];
//		long fibo[] = new long[100];
//		
//	}

	public static String reverse(String inputString) {
		String[] words = inputString.split(" ");
		String reverseString = "";
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String reverseWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				reverseWord = reverseWord + word.charAt(j);
			}

			reverseString = reverseString + reverseWord + " ";
		}
		return reverseString.trim();
	}

	public static String triangleType(int a, int b, int c) {
		String type = "";
		if (a == b && b == c)
			type = "Equilateral";
		else if (a >= (b + c) || c >= (b + a) || b >= (a + c))
			type = "Error";
		else if ((a == b && b != c) || (a != b && c == a) || (c == b && c != a))
			type = "Isosceles";
		else if (a != b && b != c && c != a)
			type = "Scalene";
		return type;
	}
}