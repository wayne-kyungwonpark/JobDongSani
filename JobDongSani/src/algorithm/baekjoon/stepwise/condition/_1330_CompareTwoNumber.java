package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class _1330_CompareTwoNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        if(a < b){
            System.out.println("<");
        }else if(a == b){
            System.out.println("==");
        }else{
            System.out.println(">");
        }
    }
}
