package algorithm.baekjoon.stepwise.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackImpl {

	private static void doSth(String str, List<Integer> stackList) {
		String[] strArr = str.split(" ");
		switch(strArr[0]) {
			case "push": 
				stackList.add(Integer.parseInt(strArr[1]));
				break;
			case "pop":
				if(stackList.isEmpty())
					System.out.println("-1");
				else {
					int size = stackList.size();
					System.out.println(stackList.get(size - 1));
					stackList.remove(size - 1);
				}
				break;
			case "size":
				if(stackList.isEmpty())
					System.out.println("0");
				else
					System.out.println(stackList.size());
				break;
			case "empty":
				if(stackList.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
				break;
			case "top":
				if(stackList.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stackList.get(stackList.size() - 1));
				break;
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testNum = Integer.parseInt(scn.nextLine());
		List<Integer> stackList = new ArrayList<Integer>();
		for(int i=0;i<testNum;i++) {
			doSth(scn.nextLine(), stackList);
		}
	}
}
