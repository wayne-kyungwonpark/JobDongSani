package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class StarPrintBack {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		for(int i=0;i<num;i++) {
			StringBuffer sb = new StringBuffer("");
			for(int j=0;j<num-(i+1);j++) 
				sb.append(" ");
			for(int k=0;k<(i+1);k++)
				sb.append("*");
			System.out.println(sb.toString());
		}
	}
}
