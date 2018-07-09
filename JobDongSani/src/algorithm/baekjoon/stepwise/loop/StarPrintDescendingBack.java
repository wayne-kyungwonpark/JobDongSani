package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class StarPrintDescendingBack {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		for(int i=num;i>0;i--) {
			StringBuffer sb = new StringBuffer("");
			for(int j=0;j<num-i;j++)
				sb.append(" ");
			for(int k=0;k<i;k++)
				sb.append("*");
			System.out.println(sb.toString());
		}
	}
}
