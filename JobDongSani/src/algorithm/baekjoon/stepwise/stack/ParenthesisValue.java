package algorithm.baekjoon.stepwise.stack;

import java.util.Scanner;

public class ParenthesisValue {

	private static int value = 0;
	
	private static boolean isValidParenthesis(char[] chArr) {
		int size = chArr.length;
		int[] totalCount = new int[4];
		boolean isSeparated = false;
		for(int i=0;i<size;i++) {
			if("(".equals(Character.toString(chArr[i]))) {
				totalCount[0]++;
				isSeparated = false;
			}
			else if(")".equals(Character.toString(chArr[i]))) {
				totalCount[1]++;
				if(totalCount[0] == totalCount[1] && totalCount[2] == totalCount[3]) {
					isSeparated = true;
					value += (int) Math.pow(2, totalCount[1]) * (int) Math.pow(3, totalCount[3]);
					totalCount = new int[4];
				}
			}
			else if("[".equals(Character.toString(chArr[i]))) {
				totalCount[2]++;
				isSeparated = false;
			}
			else if("]".equals(Character.toString(chArr[i]))) {
				totalCount[3]++;
				if(totalCount[0] == totalCount[1] && totalCount[2] == totalCount[3]) {
					isSeparated = true;
					value += (int) Math.pow(2, totalCount[1]) * (int) Math.pow(3, totalCount[3]);
					totalCount = new int[4];
				}
			}
			if(totalCount[0] < totalCount[1] || totalCount[2] < totalCount[3])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[] chArr = scn.nextLine().toCharArray();
		if(!isValidParenthesis(chArr))
			System.out.println("0");
		else {
			System.out.println(value);
		}
	}
}
