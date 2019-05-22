package algorithm.baekjoon.newbie2019;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = Integer.parseInt(scn.nextLine());
        String[] strArr = scn.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(strArr[i]);
            int divide3Num = 3 * sum1ToN(num / 3);
            int divide7Num = 7 * sum1ToN(num / 7);
            int divide21Num = 21 * sum1ToN(num / 21);
            System.out.println(divide3Num + divide7Num - divide21Num);
        }
        scn.close();
    }

    private static int sum1ToN(int N){
        if(N == 0){
            return 0;
        }
        return (N * (N + 1)) >> 1;
    }
}
