package algorithm.baekjoon.stepwise.rule;

import java.util.Scanner;

public class ACMHotel {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = Integer.parseInt(scn.nextLine());
		String[] roomNums = new String[num];
		for(int i=0;i<num;i++) {
			String[] info = scn.nextLine().split(" ");
			int h = Integer.parseInt(info[0]);
			int w = Integer.parseInt(info[1]);
			int th = Integer.parseInt(info[2]);
			int front = th % h;
			int back = th / h;
			if(front == 0)
				front = h;
			else
				back++;
			StringBuffer sb = new StringBuffer("");
			sb.append(Integer.toString(front));
			if(back < 10)
				sb.append("0");
			sb.append(Integer.toString(back));
			roomNums[i] = sb.toString();
		}
		for(int i=0;i<num;i++)
			System.out.println(roomNums[i]);
	}
}