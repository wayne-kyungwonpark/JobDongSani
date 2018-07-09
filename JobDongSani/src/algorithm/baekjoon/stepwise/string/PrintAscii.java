package algorithm.baekjoon.stepwise.string;

import java.util.Scanner;

public class PrintAscii {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println((int) str.toCharArray()[0]);
	}
}