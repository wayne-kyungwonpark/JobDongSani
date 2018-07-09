package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class ThreeNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		int num3 = scn.nextInt();
		if(num1 > num2) {
			if(num2 > num3)
				System.out.println(num2);
			else {
				if(num1 > num3)
					System.out.println(num3);
				else
					System.out.println(num1);
			}
		}else {//num2 >= num1
			if(num1 > num3)
				System.out.println(num1);
			else {
				if(num2 > num3)
					System.out.println(num3);
				else
					System.out.println(num2);
			}
		}
	}
}
