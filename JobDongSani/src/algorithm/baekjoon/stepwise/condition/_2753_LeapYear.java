package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class _2753_LeapYear {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();

        if((a % 4 == 0 && a % 100 != 0) || a % 400 == 0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

        scn.close();
    }
}
