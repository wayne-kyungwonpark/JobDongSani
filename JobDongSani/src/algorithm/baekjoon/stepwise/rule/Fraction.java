package algorithm.baekjoon.stepwise.rule;

import java.util.Scanner;

public class Fraction {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = Integer.parseInt(scn.nextLine());
		int inc = 1;
		int sumCheck = 1;
		while(sumCheck < num) {
			inc++;
			sumCheck += inc;
		}
		int diff = num - (sumCheck - inc);
		int diffCheck = 1;
		int numerator = 0;
		int denominator = 0;
		if(inc % 2 == 1) {
			for(int i=inc;i>0;i--) {
				if(diff != diffCheck)
					diffCheck++;
				else {
					numerator = i;
					denominator = inc + 1 - i;
					break;
				}
			}
		}else {
			for(int i=1;i<=inc;i++) {
				if(diff != diffCheck)
					diffCheck++;
				else {
					numerator = i;
					denominator = inc + 1 - i;
					break;
				}
			}
		}
		System.out.println(numerator + "/" + denominator);
	}
}