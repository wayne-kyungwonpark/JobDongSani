package algorithm.baekjoon.stepwise.string;

import java.util.Scanner;

public class FindAlphabet {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		char[] chArr = str.toCharArray();
		int[] alphaArr = new int[26];
		for(int i=0;i<alphaArr.length;i++)
			alphaArr[i] = -1;
		// a: 97 ~ z: 122
		for(int i=97;i<123;i++) {
			for(int j=0;j<chArr.length;j++) {
				if(i == (int) chArr[j]) {
					alphaArr[i-97] = j;
					break;
				}
			}
		}
		for(int i=0;i<alphaArr.length;i++)
			System.out.print(alphaArr[i] + " ");
	}
}