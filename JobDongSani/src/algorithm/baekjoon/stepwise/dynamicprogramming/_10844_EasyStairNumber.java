package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

public class _10844_EasyStairNumber {
    private static int N = 0;
    private static int[][] stairNums = null;

    private static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        stairNums = new int[N + 1][10];
        findStairNums(1);
        int num = 0;
        for (int i = 0; i < 10; i++) {
            int tmp = stairNums[N][i] % MOD;
            num = (num % MOD + tmp) % MOD;
        }
        System.out.println(num);
        scn.close();
    }

    private static void findStairNums(int index) {
        if(index > N){
            return;
        }
        if(index == 1){
            for (int i = 1; i < 10; i++) {
                stairNums[index][i] = 1;
            }
        }else{
            for (int i = 0; i < 10; i++) {
                if(i == 0){
                    stairNums[index][i] = stairNums[index - 1][i + 1];
                }else if(i == 9){
                    stairNums[index][i] = stairNums[index - 1][i - 1];
                }else{
                    stairNums[index][i] = (stairNums[index - 1][i - 1] + stairNums[index - 1][i + 1]) % MOD;
                }
            }
        }
        findStairNums(index + 1);
    }
}
