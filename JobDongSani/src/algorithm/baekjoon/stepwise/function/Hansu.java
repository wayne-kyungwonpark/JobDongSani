package algorithm.baekjoon.stepwise.function;

import java.util.Scanner;

public class Hansu {

	private static boolean checkDiff(int num) {
		String numStr = Integer.toString(num);
		char[] numCharArr = numStr.toCharArray();
		int diff = 0;
		boolean check = true;
		for(int i=0;i<numCharArr.length-1;i++) {
			if(i == 0)
				diff = Character.getNumericValue(numCharArr[i]) - Character.getNumericValue(numCharArr[i+1]);
			int tmpDiff = Character.getNumericValue(numCharArr[i]) - Character.getNumericValue(numCharArr[i+1]);
			if(diff != tmpDiff) {
				check = false;
				break;
			}
		}
		return check;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int count = 0;
		for(int i=1;i<=num;i++) {
			if(i < 100) {
				count++;
			}else {
				if(checkDiff(i))
					count++;
			}
		}
		System.out.println(count);
	}
}
