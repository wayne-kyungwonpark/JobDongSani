package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class GuGuDan {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		String str = "";
		for(int i=0;i<9;i++) {
			StringBuffer sb = new StringBuffer(Integer.toString(num) + " * ");
			sb.append(Integer.toString(i+1) + " = ");
			sb.append(Integer.toString(num * (i+1)));
			System.out.println(sb.toString());
		}
	}
}
