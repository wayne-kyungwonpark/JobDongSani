package algorithm.baekjoon.stepwise.string;

import java.util.Scanner;

public class CheckGroupWord {

	private static boolean checkGrpWord(String str) {
		char[] chArr = str.toCharArray();
		for(int i=0;i<chArr.length;i++) {
			boolean contiCheck = true;
			if(i != 0) {
				String alpha = Character.toString(chArr[i]);
				for(int j=i-1;j>=0;j--) {
					String tmpStr = Character.toString(chArr[j]);
					if(contiCheck && alpha.equals(tmpStr))
						contiCheck = true;
					else if(contiCheck && !alpha.equals(tmpStr)) 
						contiCheck = false;
					else if(!contiCheck && alpha.equals(tmpStr))
						return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = Integer.parseInt(scn.nextLine());
		int count = 0;
		for(int i=0;i<num;i++) {
			if(checkGrpWord(scn.nextLine()))
				count++;
		}
		System.out.println(count);
	}
}