package algorithm.baekjoon.stepwise.implement;

import java.util.Scanner;

public class YutNori {

	private static String decisionYut(String[] yuts) {
		int b = 0;
		for(int i=0;i<4;i++) {
			if("0".equals(yuts[i]))
				b++;
		}
		if(b == 0)
			return "E";
		else if(b == 1)
			return "A";
		else if(b == 2)
			return "B";
		else if(b == 3)
			return "C";
		else
			return "D";
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println(decisionYut(scn.nextLine().split(" ")));
		System.out.println(decisionYut(scn.nextLine().split(" ")));
		System.out.println(decisionYut(scn.nextLine().split(" ")));
	}
}
