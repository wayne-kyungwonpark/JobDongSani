package algorithm.baekjoon.stepwise.loop;

import java.util.Scanner;

public class WordDividerByTen {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String word = scn.nextLine();
		int freq = word.length() / 10 + 1;
		for(int i=0;i<freq;i++) {
			if(i != freq - 1)
				System.out.println(word.substring(i * 10, i * 10 + 10));
			else
				System.out.println(word.substring(i * 10));
		}
	}
}
