package algorithm.baekjoon.stepwise.operations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class IOSame {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<String> strList = new ArrayList<String>();
		while(scn.hasNextLine()) {
			strList.add(scn.nextLine());
		}
		for(int i=0;i<strList.size();i++) {
			String tmp2 = strList.get(i);
			System.out.println(tmp2);
		}
	}
}
