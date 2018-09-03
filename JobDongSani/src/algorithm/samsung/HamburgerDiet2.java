package algorithm.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * DP를 사용하여 Knapsack 문제 풀기
 * 1. 햄버거 재료의 calory 에 대한 gcd를 내어 해당 gcd만큼 cal을 증가시키며 dp를 위한 메모리를 채운다.
 * 2. 재료가 최대 20개이므로 최대 19번의 gcd를 사용하면 전체 재료의 gcd를 구할 수 있다.
 * 3. (option) calory를 1씩 증가시키며 메모이제이션 하는 것과 비교한다.
 * @author kpark
 *
 */
public class HamburgerDiet2 {
	
	private static int[] score;
	private static int[] cal;
	private static int[][] partialSums;
	private static int calGcd = 0;
	
	private static int findOptimum(int materialNum, int calLimit) {
		int calNum = calLimit / calGcd;
		partialSums = new int[materialNum + 1][calNum + 1]; //0, 0 포함
		for(int i=0;i<=materialNum;i++) {
			for(int j=0;j<=calNum;j++) {
				if(i == 0) {
					partialSums[i][j] = 0; 
				}else if(j == 0){
					partialSums[i][j] = 0;
				}else {
					if(j >= (cal[i - 1] / calGcd) && partialSums[i - 1][j] < score[i - 1] + partialSums[i - 1][j - (cal[i - 1] / calGcd)]) {
						partialSums[i][j] = score[i - 1] + partialSums[i - 1][j - (cal[i - 1] / calGcd)];
					}else {
						partialSums[i][j] = partialSums[i - 1][j];
					}
				}
//				System.out.print(partialSums[i][j] + " ");
			}
//			System.out.println();
		}
		return partialSums[materialNum][calNum];
	}
	
	private static int gcd(int num1, int num2) {
		if(num1 == 0) {
			return num2;
		}else if(num2 == 0) {
			return num1;
		}else {
			if(num1 >= num2) {
				return gcd(num2, num1 % num2);
			}else {
				return gcd(num1, num2 % num1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int testFreq = 0;
		int materialNum = 0;
		int materialFreq = 0;
		int calLimit = 0;
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				if(materialNum == 0) {
					String[] strArr = str.split(" ");
					materialNum = Integer.parseInt(strArr[0]);
					calLimit = Integer.parseInt(strArr[1]);
					score = new int[materialNum];
					cal = new int[materialNum];
				}else {
					String[] strArr = str.split(" ");
					score[materialFreq] = Integer.parseInt(strArr[0]);
					cal[materialFreq] = Integer.parseInt(strArr[1]);
					calGcd = gcd(calGcd, cal[materialFreq]);
					materialFreq++;
				}
				if(materialFreq == materialNum) {
					testFreq++;
					int totalScore = findOptimum(materialNum, calLimit);
					StringBuilder sb = new StringBuilder();
					sb.append("#").append(String.valueOf(testFreq)).append(" ").append(String.valueOf(totalScore));
					bw.write(sb.toString());
					bw.newLine();
					materialNum = 0;
					materialFreq = 0;
					calLimit = 0;
					score = null;
					cal = null;
					calGcd = 0;
					partialSums = null;
				}
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
