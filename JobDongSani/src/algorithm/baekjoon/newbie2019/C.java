package algorithm.baekjoon.newbie2019;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] strArr = scn.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]), testNum = Integer.parseInt(strArr[1]);
        strArr = scn.nextLine().split(" ");
        int[] nums = new int[N];
        int[] cdf = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
            if(i != 0){
                cdf[i] = Math.abs(nums[i] - nums[i - 1]) + cdf[i - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testNum; i++) {
            strArr = scn.nextLine().split(" ");
            int start = Integer.parseInt(strArr[0]), end = Integer.parseInt(strArr[1]);
            if(start == end){
                sb.append(0);
            }else{
                sb.append(cdf[end - 1] - cdf[start - 1]);
            }
            if(i != testNum){
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
        scn.close();
    }
}
