package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class LessThanX {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int total = scn.nextInt();
		int x = scn.nextInt();
		for(int i=0;i<total;i++) {
			int tmp = scn.nextInt();
			if(tmp < x)
				System.out.print(tmp + " ");
		}
	}
}
