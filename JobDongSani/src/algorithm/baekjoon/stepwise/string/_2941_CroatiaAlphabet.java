package algorithm.baekjoon.stepwise.string;

import java.util.Scanner;

public class _2941_CroatiaAlphabet {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[] chArr = scn.nextLine().toCharArray();
		int leng = chArr.length;
		boolean nextUsed = false;
		int count = 0;
		for(int i=0;i<leng;i++) {
			String str = Character.toString(chArr[i]);
			if(!nextUsed) {
				if(i != leng - 1) {
					String nextStr = Character.toString(chArr[i + 1]);
					if("c".equals(str) && ("=".equals(nextStr) || "-".equals(nextStr)))
						nextUsed = true;
					else if("l".equals(str) && "j".equals(nextStr))
						nextUsed = true;
					else if("n".equals(str) && "j".equals(nextStr))
						nextUsed = true;
					else if("s".equals(str) && "=".equals(nextStr))
						nextUsed = true;
					else if("z".equals(str) && "=".equals(nextStr))
						nextUsed = true;
					else if("d".equals(str) && ("-".equals(nextStr) || "z".equals(nextStr)))
						nextUsed = true;
				}
				count++;
			}else {
				if (i != leng - 1 && "z".equals(str)) {
					String thirdStr = Character.toString(chArr[i + 1]);
					if (!"=".equals(thirdStr)) {
						count++;
						nextUsed = false;
					}
				}else if(i == leng - 1 && "z".equals(str)){
					count++;
					nextUsed = false;
				}else {
					nextUsed = false;						
				}
			}
		}
		System.out.println(count);
	}
}