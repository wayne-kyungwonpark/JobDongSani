package algorithm.baekjoon.stepwise.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2003_SumOfNumbers2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] strArr = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }

        long sum = 0;
        int start = 0;
        int end = 0;

        int answer = 0;

        while(start < N){
            if((sum < M || start > end) && end < N){
                sum += nums[end++];
            }else{
                if(sum == M){
                    answer++;
                }
                sum -= nums[start++];

            }
        }

        System.out.println(answer);
    }
}
