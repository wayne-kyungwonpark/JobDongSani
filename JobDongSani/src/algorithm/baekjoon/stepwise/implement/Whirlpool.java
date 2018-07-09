package algorithm.baekjoon.stepwise.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Whirlpool {

	private static int findNum(int r, int c) {
		int absR = Math.abs(r);
		int absC = Math.abs(c);
		int large = (absR > absC)? absR : absC;
		int length = 2 * large + 1;
		int largest = (int)Math.pow(length, 2);
		if(r == large)
			return largest - (large - c);
		else {
			if(c == -large)
				return largest - (length - 1) - (large - r);
			else if(c == large)
				return largest - 3 * (length - 1) - (r + large);
			else
				return largest - 2 * (length - 1) - (c + large);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int r1 = 0;
		int c1 = 0;
		int r2 = 0;
		int c2 = 0;
		while((str = br.readLine()) != null) {
			String[] strArr = str.split(" ");
			r1 = Integer.parseInt(strArr[0]);
			c1 = Integer.parseInt(strArr[1]);
			r2 = Integer.parseInt(strArr[2]);
			c2 = Integer.parseInt(strArr[3]);
			break;
		}
		int[] nums = new int[(r2 - r1 + 1) * (c2 - c1 + 1)];
		int order = 0;
		int cipher = 1;
		for(int i=r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
				int value = findNum(i,j);
				if(String.valueOf(value).length() > cipher)
					cipher = String.valueOf(value).length();
				nums[order++] = value;
			}
		}
		int reOrder = 0;
		for(int i=r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
				String value = String.valueOf(nums[reOrder++]);
				if(value.length() < cipher) {
					for(int k=0;k<cipher - value.length();k++)
						bw.write(" ");
				}
				bw.write(value + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
