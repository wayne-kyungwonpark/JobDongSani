package algorithm.baekjoon.stepwise.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DescendingNumber {
//TODO 10보다 작은 descending number 수, 100보다 작은 descending number 수, 1000보다 작은... 이런 식으로 각 자릿수마다 descending number 수 세는 방법 고려
	public static boolean isDescendingNumber(long num) {
		char[] chArr = String.valueOf(num).toCharArray();
		boolean isDescending = true;
		for(int i=0;i<chArr.length-1;i++) {
			if(Long.parseLong(String.valueOf(chArr[i])) <= Long.parseLong(String.valueOf(chArr[i + 1]))) {
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
		long num = 0;
		int cnt = 0;
		long max = Long.parseLong("9876543210");
		boolean doesExist = true;
		while(cnt < ieme) {
			if(isDescendingNumber(num))
				cnt++;
			num++;
			if(num > max) {
				doesExist = false;
				break;
			}
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
