package algorithm.baekjoon.stepwise.simulation;

import java.util.Scanner;

public class Stick {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = Integer.parseInt(scn.nextLine());
		String bin = Integer.toBinaryString(x);
		char[] chArr = bin.toCharArray();
		int num = 0;
		for(int i=0;i<chArr.length;i++) {
			if(Integer.parseInt(String.valueOf(chArr[i])) == 1)
				num++;
		}
		System.out.println(num);
	}
}
