package algorithm.baekjoon.stepwise.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ball {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int total = 0;
		int freq = 0;
		String pos = "1";
		while((str = br.readLine()) != null) {
			if(freq == 0)
				total = Integer.parseInt(str);
			else {
				String[] strArr = str.split(" ");
				if(pos.equals(strArr[0]))
					pos = strArr[1];
				else if(pos.equals(strArr[1]))
					pos = strArr[0];
			}
			freq++;
			if(freq > total)
				break;
		}
		bw.write(pos);
		bw.flush();
		bw.close();
		br.close();
	}
}
