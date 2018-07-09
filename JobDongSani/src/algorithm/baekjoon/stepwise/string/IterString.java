package algorithm.baekjoon.stepwise.string;

import java.util.Scanner;

public class IterString {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = Integer.parseInt(scn.nextLine());
		String[] result = new String[num];
		for(int i=0;i<num;i++) {
			String[] str = scn.nextLine().split(" ");
			int iter = Integer.parseInt(str[0]);
			char[] testcase = str[1].toCharArray();
			StringBuffer sb = new StringBuffer("");
			for(int j=0;j<testcase.length;j++) {
				for(int k=0;k<iter;k++)
					sb.append(Character.toString(testcase[j]));
				result[i] = sb.toString();
			}
		}
		for(int i=0;i<num;i++)
			System.out.println(result[i]);
	}
}
