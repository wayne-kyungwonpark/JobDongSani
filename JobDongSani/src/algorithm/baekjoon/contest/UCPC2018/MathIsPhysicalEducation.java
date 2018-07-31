package algorithm.baekjoon.contest.UCPC2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MathIsPhysicalEducation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		while((str = br.readLine()) != null) {
			int num = Integer.parseInt(str);
			bw.write(String.valueOf(num * 4));
			break;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
