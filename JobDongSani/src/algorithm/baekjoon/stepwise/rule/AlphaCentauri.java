package algorithm.baekjoon.stepwise.rule;

import java.util.Scanner;

public class AlphaCentauri {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = Integer.parseInt(scn.nextLine());
		int[] freq = new int[num];
		for(int i=0;i<num;i++) {
			String[] positions = scn.nextLine().split(" ");
			int dist = Integer.parseInt(positions[1]) - Integer.parseInt(positions[0]);
			int count = 0;
			if(dist == 1)
				count = 1;
			else {
				int present = (int) Math.sqrt(dist);
				if(dist < present * (present + 1))
					present--;
				int diff = dist - present * (present + 1);
				if(diff == 0)
					count += present * 2;
				else if(diff <= present + 1)
					count += present * 2 + 1;
				else
					count += present * 2 + 2;
			}
			freq[i] = count;
		}
		for(int i=0;i<num;i++)
			System.out.println(freq[i]);
	}
}