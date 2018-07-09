package algorithm.baekjoon.stepwise.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DescendingNumber2 {

	public static int combination(int total, int cipherNum) {
		int start = total;
		int numerator = 1;
		int denominator = 1;
		for(int i=1;i<=cipherNum;i++) {
			numerator *= start--;
			denominator *= i;
		}
		return numerator / denominator;
	}
	
	public static boolean isDescendingNumber(int num) {
		char[] chArr = String.valueOf(num).toCharArray();
		boolean isDescending = true;
		for(int i=0;i<chArr.length-1;i++) {
			if(Integer.parseInt(String.valueOf(chArr[i])) <= Integer.parseInt(String.valueOf(chArr[i + 1]))) {
				isDescending = false;
				break;
			}
		}
		return isDescending;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int ieme = 0;
		while((str = br.readLine()) != null) {
			ieme = Integer.parseInt(str);
			break;
		}
		int cipherNum = 1;
		boolean doesExist = true;
		int combinationSum = -1;
		long num = 0;
		while(combinationSum <= ieme) {
			if(cipherNum > 9) {
				if(combinationSum + combination(10, 10) == ieme)
					num = 9876543210l;
				else
					doesExist = false;
				break;
			}else if(combinationSum + combination(10, cipherNum) >= ieme){
				StringBuilder sb = new StringBuilder("");
				for(int i=cipherNum-1;i>=0;i--)
					sb.append(String.valueOf(i));
				int tmp = Integer.parseInt(sb.toString());
				int cnt = combinationSum;
				while(cnt < ieme) {
					if(isDescendingNumber(tmp))
						cnt++;
					tmp++;
				}
				num = tmp - 1;
				break;
			}else
				combinationSum += combination(10, cipherNum++);
		}
		if(doesExist)
			bw.write(String.valueOf(num));
		else
			bw.write("-1");
		bw.flush();
		br.close();
		bw.close();
	}
}
