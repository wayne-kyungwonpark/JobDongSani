package algorithm.baekjoon.stepwise.stack;

import java.util.Scanner;

public class _9012_ParenthesisString {

	private static void checkVps(String str) {
		char[] chArr = str.toCharArray();
		int size = chArr.length;
		if(")".equals(Character.toString(chArr[0])) || "(".equals(Character.toString(chArr[size -1])))
			System.out.println("NO");
		else {
			boolean isValid = true;
			int count1 = 0;
			int count2 = 0;
			for(int i=0;i<size;i++) {
				if("(".equals(Character.toString(chArr[i])))
					count1++;
				else if(")".equals(Character.toString(chArr[i])))
					count2++;
				if(count1 < count2) {
					isValid = false;
					break;
				}
			}
			if(count1 != count2) {
				System.out.println("NO");
				isValid = false;
			}
			if(isValid)
				System.out.println("YES");
		}	
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		for(int i=0;i<testNum;i++) {
			checkVps(scn.nextLine());
		}
	}
}
