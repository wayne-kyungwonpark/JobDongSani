package algorithm.baekjoon.stepwise.string;

import java.util.Scanner;

public class Dial {

	private static int findNumFromAlpha(char ch) {
		int chNum = (int) ch;
		if(chNum < 68)
			return 2;
		else if(chNum < 71)
			return 3;
		else if(chNum < 74)
			return 4;
		else if(chNum < 77)
			return 5;
		else if(chNum < 80)
			return 6;
		else if(chNum < 84)
			return 7;
		else if(chNum < 87)
			return 8;
		else
			return 9;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[] dialAlpha = scn.nextLine().toCharArray();
		int totalTime = 0;
		for(int i=0;i<dialAlpha.length;i++) {
			totalTime += findNumFromAlpha(dialAlpha[i]);
			totalTime++;
		}
		System.out.println(totalTime);
	}
}
