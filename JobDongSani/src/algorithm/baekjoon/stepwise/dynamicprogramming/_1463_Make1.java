package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

public class _1463_Make1 {
    private static int N = 0;
    private static int[] minOperationNums = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        minOperationNums = new int[N + 1];
        findMinOperationNums(1);
        System.out.println(minOperationNums[N]);
        scn.close();
    }

    private static void findMinOperationNums(int index) {
        if(index > N){
            return;
        }
        if(index == 1){
            minOperationNums[index] = 0;
        }else if(index == 2){
            minOperationNums[index] = 1;
        }else if(index == 3){
            minOperationNums[index] = 1;
        }else{
            minOperationNums[index] = minOperationNums[index - 1] + 1;
            if(index % 3 == 0){
                minOperationNums[index] = Math.min(minOperationNums[index / 3] + 1, minOperationNums[index]);
            }else if(index % 2 == 0){
                minOperationNums[index] = Math.min(minOperationNums[index / 2] + 1, minOperationNums[index]);
            }
        }
        findMinOperationNums(index + 1);
    }
}
