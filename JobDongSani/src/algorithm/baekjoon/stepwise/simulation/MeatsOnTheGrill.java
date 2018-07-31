package algorithm.baekjoon.stepwise.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MeatsOnTheGrill {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int testNumCheck = 0;
		int rowNum = 0;
		int colNum = 0;
		int order = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {//테스트케이스 갯수가 0일 때 (첫 줄)
				testNum = Integer.valueOf(str);
			}else {
				if(rowNum == 0) {// 새로운 테스트케이스 시작 시
					String[] strArr = str.split(" ");
					rowNum = Integer.parseInt(strArr[0]);
					colNum = Integer.parseInt(strArr[1]);
				}else {
					char[] meats = str.toCharArray();
					for(int i=colNum-1;i>=0;i--) {
						bw.write(String.valueOf(meats[i]));
					}
					bw.newLine();
					order++;
					if(rowNum == order) {
						rowNum = 0;
						colNum = 0;
						order = 0;
						testNumCheck++;
						if(testNumCheck == testNum)
							break;
					}
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
