package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.util.Scanner;

public class _1904_01Tile {
    // f(N): N 길이의 2진수열 갯수
    // f(N) = f(N - 1) + f(N - 2) (if N >= 3) (xxx00 or xxxx1 둘 중 하나임 xxx 는 N -2 자리, xxxx 는 N - 1자리의 임의의 수)
    // (N = 1) 1
    // (N = 2) 00 11
    // (N = 3) 001 100 111
    // (N = 4) 0000 0011 1100 1111 1001
    // (N = 5) 00001 00100 10000 00111 10011 11001 11100 11111
    // (N = 6) 000000 000011 001001 100001 001100 100100 110000 001111 100111 110011 111001 111100 111111

    private static int[] nums = new int[1000001];
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        nums[0] = 1; nums[1] = 1;
        for (int i = 2; i <= N; i++) {
            int tmp = nums[i - 2] + nums[i - 1];
            if(tmp >= 15746){
                nums[i] = tmp %  15746;
            }else{
                nums[i] = tmp;
            }
        }
        System.out.println(nums[N]);
        scn.close();
    }
}
