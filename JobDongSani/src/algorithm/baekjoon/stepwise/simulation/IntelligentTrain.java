package algorithm.baekjoon.stepwise.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IntelligentTrain {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = null;
		int[] peoples = new int[4];
		int freq = 0;
		int max = 0;
		while((str = br.readLine()) != null) {
			if(freq == 0) {
				peoples[0] = Integer.parseInt(str.split(" ")[1]);
				max = peoples[0];
			}
			else {
				String[] outIn = str.split(" ");
				peoples[freq] = peoples[freq - 1] + Integer.parseInt(outIn[1]) - Integer.parseInt(outIn[0]);
				if(peoples[freq] > max)
					max = peoples[freq];
			}
			freq++;
			if(freq == 4)
				break;
		}
		bw.write(String.valueOf(max));
		bw.flush();
		br.close();
		bw.close();
	}
}
