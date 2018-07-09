package algorithm.baekjoon.stepwise.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FastSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int iter = 0;
		int freq = 0;
		while((str = br.readLine()) != null && iter<=freq) {
			if(iter != 0) {
				StringTokenizer token = new StringTokenizer(str);
				int sum = Integer.parseInt(token.nextToken()) + Integer.parseInt(token.nextToken());
				bw.write(Integer.toString(sum));
				bw.newLine();
			}else {
				freq = Integer.parseInt(str);
			}
			iter++;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
