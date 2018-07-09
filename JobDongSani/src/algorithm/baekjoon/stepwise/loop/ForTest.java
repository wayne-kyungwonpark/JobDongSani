package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int end = scn.nextInt();
		int sum = 0;
		for(int i=0;i<end;i++)
			sum += i+1;
		System.out.println(sum);
	}
}
