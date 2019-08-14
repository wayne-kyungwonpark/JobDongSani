package algorithm.baekjoon.stepwise.math;

import java.util.Scanner;

public class _2004_CombinationZeroNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        long m = scn.nextLong();
        long diff = n - m;
        long start5 = 5l;
        long ans5 = 0l;
        while(start5 <= n){
            ans5 += (n / start5);
            start5 *= 5l;
        }
        start5 = 5l;
        while(start5 <= m){
            ans5 -= (m / start5);
            start5 *= 5l;
        }
        start5 = 5l;
        while(start5 <= diff){
            ans5 -= (diff / start5);
            start5 *= 5l;
        }
        long start2 = 2l;
        long ans2 = 0l;
        while(start2 <= n){
            ans2 += (n / start2);
            start2 *= 2l;
        }
        start2 = 2l;
        while(start2 <= m){
            ans2 -= (m / start2);
            start2 *= 2l;
        }
        start2 = 2l;
        while(start2 <= diff){
            ans2 -= (diff / start2);
            start2 *= 2l;
        }

        System.out.println(Math.min(ans2, ans5));
    }
}
