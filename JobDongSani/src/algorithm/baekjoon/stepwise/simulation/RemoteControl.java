package algorithm.baekjoon.stepwise.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RemoteControl {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int chNum = 0;
		int buttonNum = 0;
		while((str = br.readLine()) != null) {
			if(chNum == 0) {
				chNum = Integer.parseInt(str);
			}else if(buttonNum == 0) {
				buttonNum = Integer.parseInt(str);
			}else {
				
			}
		}
	}
}
