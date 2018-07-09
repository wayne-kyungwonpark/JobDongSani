package algorithm.baekjoon.stepwise.bruteforce;

public class CombiTest {

	public static int combination(int total, int cipherNum) {
		int start = total;
		int numerator = 1;
		int denominator = 1;
		for(int i=1;i<=cipherNum;i++) {
			numerator *= start--;
			denominator *= i;
		}
		return numerator / denominator;
	}
	
	public static void main(String[] args) {
//		System.out.println(Integer.parseInt("9876543210"));
		long m = 9876543210l;
		for(int i=0;i<=10;i++)
			System.out.println(combination(10,i));
	}

}
