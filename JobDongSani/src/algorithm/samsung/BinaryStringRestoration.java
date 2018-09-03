package algorithm.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinaryStringRestoration {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int testFreq = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.valueOf(str);
			}else {
				testFreq++;
				StringBuilder sb = new StringBuilder();
				sb.append("#").append(String.valueOf(testFreq)).append(" ").append(str);
			}
			if(testNum == testFreq) {
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
