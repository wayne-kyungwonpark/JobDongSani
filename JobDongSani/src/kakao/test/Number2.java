package kakao.test;

import java.util.Arrays;

public class Number2 {

	private static int[] solution(int N, int[] stages) {
		int[] answer = {};
		int[] cdf = new int[N + 2];
		int[] currentNums = new int[N + 2];
		double[] failPercent = new double[N + 2];
		for(int i=0;i<stages.length;i++) {
			currentNums[stages[i]]++;
		}
		cdf[1] = currentNums[1];
		for(int i=2;i<currentNums.length;i++) {
			cdf[i] = cdf[i - 1] + currentNums[i];
		}
		for(int i=1;i<failPercent.length;i++) {
			if(cdf[N + 1] - cdf[i - 1] == 0) {
				failPercent[i] = 0;
			}else {
				failPercent[i] = (double) currentNums[i] / (cdf[N + 1] - cdf[i - 1]);
			}
		}
		double[] copiedFailPercent = Arrays.copyOf(failPercent, N + 1);
		Arrays.sort(copiedFailPercent);
		answer = new int[N];
		int answerFreq = 0;
		double preValue = 0;
		for(int i=copiedFailPercent.length-1;i>=1;i--) {
			if(Double.compare(preValue, copiedFailPercent[i]) != 0) {
				for(int j=1;j<failPercent.length-1;j++) {
					if(Double.compare(copiedFailPercent[i], failPercent[j]) == 0) {
						answer[answerFreq] = j;
						answerFreq++;
					}
				}
				preValue = copiedFailPercent[i];				
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int N = 6;
//		int[] stages = {2,1,2,6,2,4,3,3};
//		int N = 4;
//		int[] stages = {4,4,4,4,4};
		int[] stages = {2,4,2,4,2,4};
		int[] result = solution(N, stages);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
}
