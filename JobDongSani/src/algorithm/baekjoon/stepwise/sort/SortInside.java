package algorithm.baekjoon.stepwise.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SortInside {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[] chArr = scn.nextLine().toCharArray();
		Arrays.sort(chArr);
		for(int i=chArr.length-1;i>=0;i--)
			System.out.print(Integer.parseInt(Character.toString(chArr[i])));
	}
}
