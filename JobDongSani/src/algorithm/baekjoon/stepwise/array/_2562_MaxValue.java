package algorithm.baekjoon.stepwise.array;

import java.util.Scanner;

public class _2562_MaxValue {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int max = 0, index = 0;
        for (int i = 0; i < 9; i++) {
            if(i == 0){
                max = scn.nextInt();
                index = 1;
            }else{
                int a = scn.nextInt();
                if(max < a){
                    max = a;
                    index = i + 1;
                }
            }
            if(i != 8){
                scn.nextLine();
            }
        }
        System.out.println(max);
        System.out.println(index);
        scn.close();
    }
}
