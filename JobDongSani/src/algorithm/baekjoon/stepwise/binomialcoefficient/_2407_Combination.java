package algorithm.baekjoon.stepwise.binomialcoefficient;

import java.math.BigInteger;
import java.util.Scanner;

public class _2407_Combination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        BigInteger[][] combination = new BigInteger[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    combination[i][j] = BigInteger.ONE;
                }else{
                    combination[i][j] = combination[i - 1][j - 1].add(combination[i - 1][j]);
                }
                if(i == n && j == m){
                    System.out.println(combination[n][m].toString());
                    break;
                }
            }
        }

        scn.close();
    }
}
