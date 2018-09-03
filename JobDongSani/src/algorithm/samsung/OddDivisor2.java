package algorithm.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OddDivisor2 {
	
	private static long[] sums = new long[1000001];
	private static long[] cdf = new long[1000001];

	private static long sumOfOddDivisor(int num) {
		long sum = 0;
		// 홀수인 경우 바로 찾아버리기
		if(num % 2 == 1) {
			int sqrtNum = (int) Math.sqrt(num);
			for(int i=3;i<=sqrtNum;i+=2) {
				if(num % i == 0) {
					sum += i;
					int quotient = num / i;
					if(i != quotient) {
						sum += quotient;
					}
				}
			}
			sum += 1;
			if(1 != num) {
				sum += num;
			}
			sums[num] = sum;
		}else { // 짝수인 경우 2로 나눌 수 있을 만큼 나눠서 찾아버리기
			int tmp = num;
			while(tmp % 2 == 0) {
				tmp /= 2;
			}
			if(sums[tmp] == 0) {
				int sqrtNum = (int) Math.sqrt(tmp);
				for(int i=3;i<=sqrtNum;i+=2) {
					if(tmp % i == 0) {
						sum += i;
						int quotient = tmp / i;
						if(i != quotient) {
							sum += quotient;
						}
					}
				}
				sum += 1;
				if(1 != tmp) {
					sum += tmp;
				}
//				while(tmp <= num) {
//					sums[tmp] = sum;
//					tmp *= 2;
//				}
			}else {
				sum = sums[tmp];
//				while(tmp <= num) {
//					sums[tmp] = sum;
//					tmp *= 2;
//				}
			}
		}
		return sum;
	}
	
	private static void fill() {
		long sum = 0;
		long cumulativeSum = 0;
		for(int i=1;i<=1000000;i++) {
			cumulativeSum += sumOfOddDivisor(i);
			cdf[i] = cumulativeSum;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		int testNum = 0;
		int testFreq = 0;
		
		fill();
		
		while((str = br.readLine()) != null) {
			if(testNum == 0) {
				testNum = Integer.parseInt(str);
			}else {
				testFreq++;
				String[] strArr = str.split(" ");
				int start = Integer.parseInt(strArr[0]);
				int end = Integer.parseInt(strArr[1]);
				long sum = cdf[end] - cdf[start - 1];
				
				StringBuilder sb = new StringBuilder();
				sb.append("#").append(String.valueOf(testFreq)).append(" ").append(String.valueOf(sum));
				bw.write(sb.toString());
				bw.newLine();
			}
			if(testFreq == testNum) {
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
