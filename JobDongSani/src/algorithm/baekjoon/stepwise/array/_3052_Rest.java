package algorithm.baekjoon.stepwise.array;

import java.util.Scanner;

public class _3052_Rest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean[] check = new boolean[42];
        int restNum = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(scn.nextLine());
            int rest = num % 42;
            if(!check[rest]){
                check[rest] = true;
                restNum++;
            }
        }
        System.out.println(restNum);
        scn.close();
    }
}
