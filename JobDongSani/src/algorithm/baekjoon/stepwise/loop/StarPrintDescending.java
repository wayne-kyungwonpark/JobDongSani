package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class StarPrintDescending {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		for(int i=num;i>0;i--) {
			StringBuffer sb = new StringBuffer("");
			for(int j=0;j<i;j++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
	}
}
