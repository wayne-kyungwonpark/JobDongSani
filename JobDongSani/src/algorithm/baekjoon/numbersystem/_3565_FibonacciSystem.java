package algorithm.baekjoon.numbersystem;

import java.util.ArrayList;
import java.util.Scanner;

public class _3565_FibonacciSystem {
    private static ArrayList<Integer> fibonacci;
    private static ArrayList<Integer> oneToNLen;
    private static ArrayList<Integer> numberOfOnes;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int num = 1;
        fibonacci = new ArrayList(); fibonacci.add(1); fibonacci.add(1);
        oneToNLen = new ArrayList(); oneToNLen.add(1);
        numberOfOnes = new ArrayList(); numberOfOnes.add(1);
        while(oneToNLen.get(oneToNLen.size() - 1) < N){
            if(num > fibonacci.size() - 1){
                fibonacci.add(fibonacci.get(fibonacci.size() - 2) + fibonacci.get(fibonacci.size() - 1));
            }
            num++;
        }

        scn.close();
    }
}
