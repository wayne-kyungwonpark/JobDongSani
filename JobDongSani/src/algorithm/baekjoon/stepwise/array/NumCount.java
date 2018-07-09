package algorithm.baekjoon.stepwise.array;

import java.util.Scanner;

public class NumCount {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		int num3 = scn.nextInt();
		int result = num1 * num2 * num3;
		char[] resultArr = Integer.toString(result).toCharArray();
		int[] cntArr = new int[10];
		for(int i=0;i<10;i++)
			cntArr[i] = 0;
		for(int i=0;i<10;i++) {
			for(int j=0;j<resultArr.length;j++) {
				if(Character.getNumericValue(resultArr[j]) == i)
					cntArr[i]++;
			}
		}
		for(int i=0;i<10;i++)
			System.out.println(cntArr[i]);
	}
}
