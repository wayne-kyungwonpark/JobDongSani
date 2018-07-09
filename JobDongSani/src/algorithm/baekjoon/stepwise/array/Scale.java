package algorithm.baekjoon.stepwise.array;

import java.util.Scanner;

public class Scale {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		if("1 2 3 4 5 6 7 8".equals(str))
			System.out.println("ascending");
		else if("8 7 6 5 4 3 2 1".equals(str))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
