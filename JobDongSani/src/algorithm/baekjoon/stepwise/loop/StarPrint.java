package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class StarPrint {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		StringBuffer sb = new StringBuffer("");
		for(int i=0;i<num;i++) {
			sb.append("*");
			System.out.println(sb.toString());
		}
	}
}
