package kakao.test;

import java.util.Arrays;

public class Number4 {

	private static int solution(int[] food_times, long k) {
		int answer = 0;
		long K = k + 1;
		int[] copiedFood_times = Arrays.copyOf(food_times, food_times.length);
		Arrays.sort(copiedFood_times);
		int roundTime = food_times.length;
		int[] outFood = new int[food_times.length];
		long leftTime = 0;
		long roundNums = 0;
		int preValue = 0;
		for(int i=0;i<copiedFood_times.length;i++) {
			if(preValue != copiedFood_times[i]) {
				preValue = copiedFood_times[i];
				copiedFood_times[i] -= roundNums;
				if(K <= roundTime * copiedFood_times[i]) {
					leftTime = K % roundTime;
					if(leftTime == 0) {
						leftTime = roundTime;
					}
					int tmp = 0;
					for(int j=0;j<food_times.length;j++) {
						if(outFood[j] == 0) {
							tmp++;
							if(tmp == leftTime) {
								answer = j + 1;
								break;
							}
						}
					}
					break;
				}else {
					K -= roundTime * copiedFood_times[i];
					for(int j=0;j<food_times.length;j++) {
						if(food_times[j] == (copiedFood_times[i] + roundNums)) {
							outFood[j] = 1;
							roundTime--;
						}
					}
					roundNums += copiedFood_times[i];
					if(roundTime == 0) {
						answer = -1;
						break;
					}
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] food_times = {4,3,4,3,4};
		int k = 6;
//		System.out.println(solution(food_times, k));
		for(int i=1;i<=18;i++) {
			System.out.print(solution(food_times, i));
			System.out.print(" ");
		}
	}
}
