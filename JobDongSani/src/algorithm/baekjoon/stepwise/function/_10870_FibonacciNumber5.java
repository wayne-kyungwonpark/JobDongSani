package algorithm.baekjoon.stepwise.function;

import java.util.Scanner;

public class _10870_FibonacciNumber5 {

    private static int[] fibonacci = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        if(num == 0){
            System.out.println(0);
        }else{
            fibonacci = new int[num + 1];
            fibonacci[0] = 0;
            doSomething(num);
            System.out.println(fibonacci[num]);
        }
        scn.close();
    }

    private static void doSomething(int num) {
        for (int i = 0; i <= num; i++) {
            if(i == 1){
                fibonacci[i] = 1;
            }else if(i > 1){
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
        }
    }
}
