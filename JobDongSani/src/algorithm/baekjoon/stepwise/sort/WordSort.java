package algorithm.baekjoon.stepwise.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordSort {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		String[] strArr = new String[testNum];
		int max = 0;
		for(int i=0;i<testNum;i++) {
			strArr[i] = scn.nextLine();
			if(max < strArr[i].length())
				max = strArr[i].length();
		}
		Arrays.sort(strArr);
		for(int j=1;j<=max;j++) {
			List<String> dupCheckList = new ArrayList<String>();
			for(int i=0;i<testNum;i++) {
				if(strArr[i].length() == j && !dupCheckList.contains(strArr[i])) {
					System.out.println(strArr[i]);
					dupCheckList.add(strArr[i]);
				}
			}
		}
	}
}