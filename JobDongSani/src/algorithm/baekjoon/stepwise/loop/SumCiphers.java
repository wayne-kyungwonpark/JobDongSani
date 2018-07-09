package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class SumCiphers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		char[] num = str2.toCharArray();
		int sum = 0;
		for(int i=0;i<Integer.parseInt(str1);i++)
			sum += Character.getNumericValue(num[i]);
		System.out.println(sum);
	}
}
