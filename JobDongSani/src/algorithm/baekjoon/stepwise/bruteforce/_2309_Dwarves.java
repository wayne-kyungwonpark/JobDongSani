package algorithm.baekjoon.stepwise.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2309_Dwarves {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int[] heights = new int[9];
		int i = 0;
		int sum = 0;
		while((str = br.readLine()) != null) {
			heights[i++] = Integer.parseInt(str);
			sum += Integer.parseInt(str);
			if(i == 9)
				break;
		}
		int diff = sum - 100;
		Arrays.sort(heights);
		boolean isEnded = false;
		for(int j=0;j<8;j++) {
			for(int k=j+1;k<9;k++) {
				if(heights[j] + heights[k] == diff) {
					isEnded = true;
					for(int l=0;l<9;l++) {
						if(l != j && l != k) {
							bw.write(String.valueOf(heights[l]));
							bw.newLine();
						}
					}
					bw.flush();
					break;
				}
			}
			if(isEnded){
				break;
			}
		}
		br.close();
		bw.close();
	}
}
