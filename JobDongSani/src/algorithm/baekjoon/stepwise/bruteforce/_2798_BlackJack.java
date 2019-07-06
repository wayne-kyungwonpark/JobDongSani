package algorithm.baekjoon.stepwise.bruteforce;

import java.util.Scanner;

public class _2798_BlackJack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt(), M = scn.nextInt(); scn.nextLine();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scn.nextInt();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int partialSum = nums[i] + nums[j];
                for (int k = j + 1; k < N; k++) {
                    int sum = partialSum + nums[k];
                    if(sum <= M && sum > max){
                        max = sum;
                    }
                    if(max == M){
                        break;
                    }
                }
                if(max == M){
                    break;
                }
            }
            if(max == M){
                break;
            }
        }
        System.out.println(max);
        scn.close();
    }
}
