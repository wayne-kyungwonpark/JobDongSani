package algorithm.baekjoon.stepwise.array;

import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		String[] wordArr = str.split(" ");
		int cnt = 0;
		for(int i=0;i<wordArr.length;i++) {
			if(!"".equals(wordArr[i]))
				cnt++;
		}
		System.out.println(cnt);
	}
}
