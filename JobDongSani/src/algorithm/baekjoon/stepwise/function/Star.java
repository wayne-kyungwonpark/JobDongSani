package algorithm.baekjoon.stepwise.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Star {

	private static String base1 = "  *  ";
	private static String base2 = " * * ";
	private static String base3 = "*****";
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int multiplier = 0;
		int numTmp = num / 3;
		while(numTmp != 1) {
			numTmp /= 2;
			multiplier++;
		}
		List<String> base = new ArrayList<String>();
		base.add(base1);
		base.add(base2);
		base.add(base3);
		for(int i=0;i<multiplier;i++) {
			List<String> beforeBaseList = new ArrayList<String>();
			beforeBaseList.addAll(base);
			int beforeSize = beforeBaseList.size();			
			base.clear();
			base = new ArrayList<String>();
			for(int j=0;j<beforeSize;j++) {
				StringBuffer sb = new StringBuffer("");
				for(int k=0;k<beforeBaseList.size();k++) {
					sb.append(" ");
				}
				String tmpStr = sb.toString() + beforeBaseList.get(j) + sb.toString();
				base.add(tmpStr);
			}
			for(int j=0;j<beforeSize;j++) {
				String tmpStr2 = beforeBaseList.get(j) + " " + beforeBaseList.get(j);
				base.add(tmpStr2);
			}
			beforeBaseList.clear();
		}
		for(int i=0;i<num;i++) {
			System.out.println(base.get(i));
		}
	}
}
