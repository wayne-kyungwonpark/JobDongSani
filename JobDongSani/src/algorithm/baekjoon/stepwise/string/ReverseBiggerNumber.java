package algorithm.baekjoon.stepwise.string;

import java.util.Scanner;

public class ReverseBiggerNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] twoNums = scn.nextLine().split(" ");
		int[] reverseNums = new int[2];
		for(int i=0;i<2;i++) {
			char[] chArr = twoNums[i].toCharArray();
			StringBuffer sb = new StringBuffer("");
			for(int j=chArr.length-1;j>=0;j--) {
				sb.append(Character.toString(chArr[j]));
			}
			reverseNums[i] = Integer.parseInt(sb.toString());
		}
		if(reverseNums[0] < reverseNums[1])
			System.out.println(reverseNums[1]);
		else
			System.out.println(reverseNums[0]);
	}
}